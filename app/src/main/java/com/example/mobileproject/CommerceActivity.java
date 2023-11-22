package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class CommerceActivity extends AppCompatActivity {

    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hiding the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_commerce);

        final TextView textView10 = (TextView) findViewById(R.id.textView39);
        final TextView textView11 = (TextView) findViewById(R.id.textView40);
        final TextView textView12 = (TextView) findViewById(R.id.textView41);



        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new
                        Intent(getApplicationContext(),AccountancyActivity.class);
                startActivity(i);
            }
        });

        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new
                        Intent(getApplicationContext(),BusinessActivity.class);
                startActivity(i);
            }
        });

        textView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new
                        Intent(getApplicationContext(),EconomicsActivity.class);
                startActivity(i);
            }
        });
    }
}