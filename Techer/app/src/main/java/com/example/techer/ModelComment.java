package com.example.techer;

public class ModelComment {
    //Fields
    String cId, cTimestamp, comment, uEmail, uName;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcTimestamp() {
        return cTimestamp;
    }

    public void setcTimestamp(String cTimestamp) {
        this.cTimestamp = cTimestamp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public ModelComment(String cId, String cTimestamp, String comment, String uEmail, String uName) {
        this.cId = cId;
        this.cTimestamp = cTimestamp;
        this.comment = comment;
        this.uEmail = uEmail;
        this.uName = uName;
    }
}
