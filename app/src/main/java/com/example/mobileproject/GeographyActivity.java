package com.example.mobileproject;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class GeographyActivity extends AppCompatActivity {

    Button btn;

    private Uri filePath;

    String fileName ;

    public static FirebaseUser user;
    StorageReference storageReference;

    ProgressBar progressBar;

    public String fbpath="pdf/Art/Geography/";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // hiding the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_geography);

        System.out.println("created");

        btn = findViewById(R.id.btnge4);

        storageReference = FirebaseStorage.getInstance().getReference();
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.GONE);    // Hide the ProgressBar


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("btnonclick");
                choosePDF();
            }
        });

    }

    private void choosePDF() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF"), 100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();

            uploadPDF();
        }
    }

    private void uploadPDF() {
        if (filePath != null) {

            progressBar.setVisibility(View.VISIBLE); // Show the ProgressBar

            File file = new File(filePath.getPath());
            fileName = file.getName();
            System.out.println("fileName wrkinhjhgbj");
            System.out.println(fileName);


            StorageReference pdfRef = storageReference.child(fbpath+fileName);


            pdfRef.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            progressBar.setVisibility(View.GONE);    // Hide the ProgressBar

                            Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            progressBar.setVisibility(View.GONE);    // Hide the ProgressBar

                            Toast.makeText(getApplicationContext(), "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }


    public void retrievePDF(View view) {


        Intent intent = new Intent(getApplicationContext(), Shoew_pdf.class);
        intent.putExtra("text",fbpath);
        startActivity(intent);
    }
}
