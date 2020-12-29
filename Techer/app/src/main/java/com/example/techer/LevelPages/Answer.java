package com.example.techer.LevelPages;

public class Answer {

    public String answer;
    public boolean isRight;

    public Answer(String answer){
        this.answer = answer;
        isRight = false;
    }

    public void setRight(boolean right){
        this.isRight = right;
    }

    public String getAnswer(){
        return this.answer;
    }
}
