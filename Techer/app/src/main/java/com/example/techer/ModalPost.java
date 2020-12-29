package com.example.techer;
/**
 * @author Arda Barış Örtlek
 */
public class ModalPost {
    String userName, userSurname, userEmail, userTitle, userDescription, userTimestamp,userLikes;

    public ModalPost(String userName, String userSurname, String userEmail, String userTitle, String userDescription, String userTimestamp, String userLikes) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.userTitle = userTitle;
        this.userDescription = userDescription;
        this.userTimestamp = userTimestamp;
        this.userLikes = userLikes;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getUserTimestamp() {
        return userTimestamp;
    }

    public void setUserTimestamp(String userTimestamp) {
        this.userTimestamp = userTimestamp;
    }

    public String getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(String userLikes) {
        this.userLikes = userLikes;
    }

}


