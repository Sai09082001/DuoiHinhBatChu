package com.example.duoihinhbatchu.entity;

public class Question {
    private String idName;
    private String title;

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Question(String idName, String title) {
        this.idName = idName;
        this.title = title;
    }
}
