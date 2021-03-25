package com.example.duoihinhbatchu;

import android.app.Application;

public class App extends Application {
    private static App instance;
    private Storage storage;

    public Storage getStorage() {
        return storage;
    }

    public static App getInstance() {
        if(instance == null) instance = new App();
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        storage=new Storage();
    }
}
