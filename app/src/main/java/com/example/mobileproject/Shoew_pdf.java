package com.example.mobileproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class Shoew_pdf extends Activity {

    private StorageReference storageReference;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoew_pdf);

        storageReference = FirebaseStorage.getInstance().getReference();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Specify the path to the PDF folder in Firebase Storage
        String textToDisplay = getIntent().getStringExtra("text");
        String pdfFolderPath = textToDisplay;

        // Retrieve the list of PDF files in the folder
        StorageReference folderRef = storageReference.child(pdfFolderPath);
        folderRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                List<String> pdfFileNames = new ArrayList<>();
                List<String> pdfFileUrls = new ArrayList<>();

                // Iterate over the list of PDF files
                for (StorageReference item : listResult.getItems()) {
                    String fileName = item.getName();
                    pdfFileNames.add(fileName);

                    item.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            String downloadUrl = uri.toString();
                            pdfFileUrls.add(downloadUrl);

                            // Check if both the file names and URLs lists have the same size
                            if (pdfFileNames.size() == pdfFileUrls.size()) {
                                // Create and set the adapter with the file names and URLs
                                RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
                                    @NonNull
                                    @Override
                                    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                                        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pdf, parent, false);
                                        return new PdfViewHolder(itemView);
                                    }

                                    @Override
                                    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                                        String fileName = pdfFileNames.get(position);
                                        String fileUrl = pdfFileUrls.get(position);
                                        ((PdfViewHolder) holder).bind(fileName, fileUrl);
                                    }

                                    @Override
                                    public int getItemCount() {
                                        return pdfFileNames.size();
                                    }
                                };

                                // Set the adapter on the RecyclerView
                                recyclerView.setAdapter(adapter);
                            }
                        }
                    });
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Handle any errors that occur while retrieving the PDF files
                // ...
            }
        });
    }

    public static class PdfViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewFileName;
        private Button buttonDownload;

        public PdfViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewFileName = itemView.findViewById(R.id.textViewFileName);
            buttonDownload = itemView.findViewById(R.id.buttonDownload);
        }

        public void bind(String fileName, String fileUrl) {
            textViewFileName.setText(fileName);

            buttonDownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Open the PDF file URL in a browser
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(fileUrl));
                    v.getContext().startActivity(browserIntent);
                }
            });
        }
    }
}
