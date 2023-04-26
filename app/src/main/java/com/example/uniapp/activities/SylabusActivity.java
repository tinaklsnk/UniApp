package com.example.uniapp.activities;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.uniapp.R;
import com.example.uniapp.fragments.PDFmodel;
import com.example.uniapp.adapters.PdfAdapter;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class SylabusActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<PDFmodel> pdfList = new ArrayList<>();
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sylabus);

        recyclerView = findViewById(R.id.sylabus_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PdfAdapter adapter = new PdfAdapter(pdfList, this);
        recyclerView.setAdapter(adapter);

        path = getIntent().getStringExtra("path");
        retrievePDFs();
    }

    private void retrievePDFs() {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        storage.getReference().child(path).listAll().addOnSuccessListener(listResult -> {
            for (StorageReference item : listResult.getItems()) {
                String title = item.getName();
                item.getDownloadUrl().addOnSuccessListener(uri -> {
                    String url = uri.toString();
                    pdfList.add(new PDFmodel(title, url));
                    recyclerView.getAdapter().notifyDataSetChanged();

                    for (PDFmodel pdf : pdfList) {
                        Log.d("PDF", "Title: " + pdf.getTitle() + ", URL: " + pdf.getUrl());
                    }

                }).addOnFailureListener(e -> {
                    Log.e(TAG,"Error downloading files");
                });
            }
        }).addOnFailureListener(e -> { });
    }
}