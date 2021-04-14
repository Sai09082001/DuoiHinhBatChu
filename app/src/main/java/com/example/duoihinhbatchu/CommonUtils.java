package com.example.duoihinhbatchu;

import com.example.duoihinhbatchu.entity.Guess;

import java.util.List;

public class CommonUtils {
    private static CommonUtils instance;
    private List<Guess> listGuess;

    public List<Guess> getListGuess() {
        return listGuess;
    }

    private CommonUtils() {
        //for singleton
    }

    public static CommonUtils getInstance(){
        if(instance==null){
            instance = new CommonUtils();
        }
        return instance;
    }

}
