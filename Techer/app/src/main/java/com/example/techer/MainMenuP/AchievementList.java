package com.example.techer.MainMenuP;

import java.util.ArrayList;

public class AchievementList {
    public ArrayList<Achievement> list;


    public AchievementList(){
        list = new ArrayList<Achievement>();
    }

    public void addAchievement(Achievement achievement){
        this.list.add(achievement);
    }


}
