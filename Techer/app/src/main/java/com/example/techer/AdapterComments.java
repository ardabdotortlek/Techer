package com.example.techer;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AdapterComments extends RecyclerView.Adapter<AdapterComments.MyHolder> {

    //Fields
    Context context;
    List<ModelComment> commentList;

    public AdapterComments(Context context, List<ModelComment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_comments, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String name = commentList.get(position).getuName();
        String email = commentList.get(position).getuEmail();
        String timestamp = commentList.get(position).getcTimestamp();
        String postComment = commentList.get(position).getComment();
        String commentId = commentList.get(position).getcId();

        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(Long.parseLong(timestamp));
        String cTime = DateFormat.format("dd/MM/yyyy hh:mm aa",calendar).toString();

        holder.cTimestamp.setText(cTime);
        holder.comment.setText(postComment);
        holder.uName.setText(name);

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView uName,comment,cTimestamp;

        public MyHolder(@NonNull View itemView){
            super(itemView);
            uName = itemView.findViewById(R.id.uName);
            comment = itemView.findViewById(R.id.comment);
            cTimestamp = itemView.findViewById(R.id.cTimestamp);
        }
    }
}
