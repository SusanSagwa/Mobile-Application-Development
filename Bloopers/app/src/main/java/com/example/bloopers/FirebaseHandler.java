package com.example.bloopers;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHandler extends Application {
    public void onCreate(){
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
