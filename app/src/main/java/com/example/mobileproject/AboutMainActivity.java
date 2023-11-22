package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

public class AboutMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hiding the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_about_main);
    }
}