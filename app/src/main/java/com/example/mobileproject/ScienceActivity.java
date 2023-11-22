package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScienceActivity extends AppCompatActivity {

    private TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hiding the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_science);

        final TextView textView5 = (TextView) findViewById(R.id.textView27);
        final TextView textView6 = (TextView) findViewById(R.id.textView28);
        final TextView textView7 = (TextView) findViewById(R.id.textView29);
        final TextView textView8 = (TextView) findViewById(R.id.textView30);


        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new
                        Intent(getApplicationContext(),physicsActivity.class);
                startActivity(i);
            }
        });

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new
                        Intent(getApplicationContext(),MathematicsActivity.class);
                startActivity(i);
            }
        });

        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new
                        Intent(getApplicationContext(),BiologyActivity.class);
                startActivity(i);
            }
        });

        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new
                        Intent(getApplicationContext(),ChemistryActivity.class);
                startActivity(i);
            }
        });

    }
}