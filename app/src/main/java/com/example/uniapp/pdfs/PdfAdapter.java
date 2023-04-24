package com.example.uniapp.pdfs;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uniapp.R;

import java.util.List;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.PdfViewHolder> {
    List<PDFmodel> pdfList;
    Context context;

    public PdfAdapter(List<PDFmodel> pdfList, Context context) {
        this.pdfList = pdfList;
        this.context = context;
    }

    @NonNull
    @Override
    public PdfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new PdfViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PdfViewHolder holder, int position) {
        PDFmodel pdf = pdfList.get(position);
        holder.pdfTitle.setText(pdf.getTitle());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse(pdf.getUrl()), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                // Handle exception
            }
        });
    }

    @Override
    public int getItemCount() {
        return pdfList.size();
    }

    public class PdfViewHolder extends RecyclerView.ViewHolder {
        TextView pdfTitle;

        PdfViewHolder(View itemView) {
            super(itemView);
            pdfTitle = itemView.findViewById(R.id.recitem_title);
        }
    }
}
