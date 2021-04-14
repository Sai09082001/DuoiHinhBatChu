package com.example.duoihinhbatchu.entity;

public class Guess {

    private String text;

    private String abc;
    public Guess(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
