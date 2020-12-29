package com.example.techer;
/**
 * @author Arda Barış Örtlek
 */
import android.content.Context;
import android.content.Intent;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AdapterPosts extends RecyclerView.Adapter<AdapterPosts.MyHolder> {
    Context context;
    List<ModalPost> postList;

    DatabaseReference likeRef;
    DatabaseReference postRef;
    FirebaseAuth mAuth;

    boolean mProcessLike = false;

    public AdapterPosts(Context context, List<ModalPost> postList) {
        this.context = context;
        this.postList = postList;
        this.likeRef = FirebaseDatabase.getInstance().getReference().child("Likes");
        this.postRef = FirebaseDatabase.getInstance().getReference().child("Posts");
        this.mAuth = FirebaseAuth.getInstance();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_posts,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String uName = postList.get(position).getUserName() + " " + postList.get(position).getUserSurname();
        String uTitle = postList.get(position).getUserTitle();
        String uEmail = postList.get(position).getUserEmail();
        String uDescription = postList.get(position).getUserDescription();
        String uTimestamp = postList.get(position).getUserTimestamp();
        String userLikes = postList.get(position).getUserLikes();

        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(Long.parseLong(uTimestamp));
        String pTime = DateFormat.format("dd/MM/yyyy hh:mm aa",calendar).toString();

        holder.userPostName.setText(uName);
        holder.userPostDate.setText(pTime);
        holder.userPostTitle.setText(uTitle);
        holder.userPostDescription.setText(uDescription);
        holder.userPostLikes.setText(userLikes + " Likes");
        setUserLikes(holder,uTimestamp);


        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pLikes = Integer.parseInt(postList.get(position).getUserLikes());
                mProcessLike = true;
                String postId = postList.get(position).getUserTimestamp();

                likeRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (mProcessLike) {
                            if (snapshot.child(postId).hasChild(mAuth.getCurrentUser().getUid())) {
                                postRef.child(postId).child("userLikes").setValue("" + (pLikes - 1));
                                likeRef.child(postId).child(mAuth.getCurrentUser().getUid()).removeValue();
                                mProcessLike = false;
                            }
                            else{
                                postRef.child(postId).child("userLikes").setValue("" + (pLikes + 1));
                                likeRef.child(postId).child(mAuth.getCurrentUser().getUid()).setValue("Liked");
                                mProcessLike = false;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

        Intent intent = new Intent(context,PostDetail.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("userTimestamp",uTimestamp);
        holder.commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return postList.size();
    }

    private void setUserLikes(final MyHolder holder,final String key){
        likeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.child(key).hasChild(mAuth.getCurrentUser().getUid())){
                    holder.likeButton.setText("LIKED!");
                }
                else{
                    holder.likeButton.setText("LIKE");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    class MyHolder extends RecyclerView.ViewHolder{

        Button likeButton, commentButton, dislikeButton;
        TextView userPostName, userPostDate, userPostTitle, userPostDescription, userPostLikes;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            likeButton = itemView.findViewById(R.id.likeButton);
            commentButton = itemView.findViewById(R.id.commentButton);
            userPostName = itemView.findViewById(R.id.userPostName);
            userPostDate = itemView.findViewById(R.id.userPostDate);
            userPostTitle = itemView.findViewById(R.id.userPostTitle);
            userPostDescription = itemView.findViewById(R.id.userPostDescription);
            userPostLikes = itemView.findViewById(R.id.userPostLikes);
        }
    }
}

