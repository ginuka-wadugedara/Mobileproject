package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class subjectsActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hiding the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_subjects2);

        Button but6=(Button) findViewById(R.id.button);
        Button but7=(Button) findViewById(R.id.button5);
        Button but8=(Button) findViewById(R.id.button6);

        but6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(subjectsActivity2.this,ArtsActivity.class);
                startActivity(int1);
            }
        });

        but7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(subjectsActivity2.this,ScienceActivity.class);
                startActivity(int2);
            }
        });

        but8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(subjectsActivity2.this,CommerceActivity.class);
                startActivity(int1);
            }
        });

    }
}