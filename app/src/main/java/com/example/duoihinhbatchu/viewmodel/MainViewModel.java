package com.example.duoihinhbatchu.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.duoihinhbatchu.App;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private List<Question> listQuestion;

    public List<Question> getListQuestion() {
        return listQuestion;
    }

    public void initData() {
        listQuestion = new ArrayList<>();
        try {
            String[] listPath = App.getInstance().getAssets().list("icon");
            for (String fileName : listPath) {
                String iconName = "icon/" + fileName;
                String title = fileName.replace(".png", "");
                listQuestion.add(new Question(iconName, title));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
