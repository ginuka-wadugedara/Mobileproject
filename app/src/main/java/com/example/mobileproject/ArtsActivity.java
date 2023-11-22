package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class ArtsActivity extends AppCompatActivity {

    private TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hiding the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_arts);

        final TextView textView5 = (TextView) findViewById(R.id.textView15);
        final TextView textView6 = (TextView) findViewById(R.id.textView16);
        final TextView textView7 = (TextView) findViewById(R.id.textView17);
        final TextView textView8 = (TextView) findViewById(R.id.textView18);


        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new
                        Intent(getApplicationContext(),GeographyActivity.class);
                startActivity(i);
            }
        });

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new
                        Intent(getApplicationContext(),HistoryActivity.class);
                startActivity(i);
            }
        });

        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new
                        Intent(getApplicationContext(),PoliticalActivity.class);
                startActivity(i);
            }
        });

        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new
                        Intent(getApplicationContext(), HomeScienceActivity2.class);
                startActivity(i);
            }
        });

    }
}