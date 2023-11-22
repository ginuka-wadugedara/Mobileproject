package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hiding the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dashboard);


        Button but1=(Button) findViewById(R.id.button14);
        Button but2=(Button) findViewById(R.id.button15);
        Button but3=(Button) findViewById(R.id.button16);
        Button but4=(Button) findViewById(R.id.button17);
        Button but5=(Button) findViewById(R.id.button18);
        Button but6=(Button) findViewById(R.id.button19);
        Button but7=(Button) findViewById(R.id.userbtn);


        but1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(DashboardActivity.this,HomeActivity.class);
                startActivity(int1);
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(DashboardActivity.this,subjectsActivity2.class);
                startActivity(int2);
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent int3 = new Intent(DashboardActivity.this,LocationActivity.class);
                startActivity(int3);
            }
        });

        but4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent int4 = new Intent(DashboardActivity.this,AboutMainActivity.class);
                startActivity(int4);
            }
        });

        but5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent int5 = new Intent(DashboardActivity.this,ContactActivity.class);
                startActivity(int5);
            }
        });

        but6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent int6 = new Intent(DashboardActivity.this,userprofilrActivity.class);
                startActivity(int6);
            }
        });

        but7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent int7 = new Intent(DashboardActivity.this,userprofilrActivity.class);
                startActivity(int7);
            }
        });
    }
}