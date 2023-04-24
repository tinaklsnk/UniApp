package com.example.uniapp.pdfs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.uniapp.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.net.URLEncoder;

public class PdfActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        // Get the PDF URL from the intent
        String pdfUrl = getIntent().getStringExtra("pdfUrl");


        // Load the PDF into the PDFView
        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromUri(Uri.parse(pdfUrl))
                .defaultPage(0)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .onPageChange((page, pageCount) -> {})
                .load();
    }
}
