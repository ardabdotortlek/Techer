package com.example.techer.MainMenuP;

import android.media.Image;
import android.widget.ImageView;

public class Achievement {

    public char achievementId;
    public ImageView image;

    public Achievement(char id){
        this.achievementId = id;
        this.image = null;
    }

    public char getAchievementId(){
        return this.achievementId;
    }

    public void setAchievementId(char id){
        this.achievementId = id;
    }

    public ImageView getImage(){
        return this.image;
    }

    public void setImage(ImageView image){
        this.image = image;
    }
}
