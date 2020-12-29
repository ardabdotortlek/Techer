package com.example.techer.LevelPages;

public class Question {
    private String theQuestion;
    Answer answer1;
    Answer answer2;
    Answer answer3;
    Answer rightAnswer;

    public Question(){
        theQuestion = "";

    }

    public void setTheQuestion(String question){
        this.theQuestion = question;
    }

    public String getTheQuestion(){
        return this.theQuestion;
    }

   public void setAnswer1(String answer){
        answer1 = new Answer(answer);
   }

   public void setAnswer2(String answer){
        answer2 = new Answer(answer);
   }

    public void setAnswer3(String answer){
        answer3 = new Answer(answer);
    }

    public void setRightAnswer(String answer){
        rightAnswer = new Answer(answer);
    }

    public String getAnswer1(){
        return answer1.getAnswer();
    }

    public String getAnswer2(){
        return answer2.getAnswer();
    }

    public String getAnswer3(){
        return answer3.getAnswer();
    }

    public String getRightAnswer(){
        return rightAnswer.getAnswer();
    }








}
