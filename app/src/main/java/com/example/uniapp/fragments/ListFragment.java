package com.example.uniapp.fragments;

import static android.content.ContentValues.TAG;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uniapp.MainActivity;
import com.example.uniapp.PDFmodel;
import com.example.uniapp.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<PDFmodel> pdfList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.my_recycler_view);

        Context context = getContext();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        dataList = new ArrayList<>();

        adapter = new RecyclerViewAdapter(context, dataList);
        recyclerView.setAdapter(adapter);


        databaseReference = FirebaseDatabase.getInstance().getReference("Android Tutorials");
        //dialog.show();
        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for (DataSnapshot itemSnapshot: snapshot.getChildren()){
                    PDFmodel dataClass = itemSnapshot.getValue(PDFmodel.class);
                    //dataClass.setKey(itemSnapshot.getKey());
                    dataList.add(dataClass);
                }
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                //dialog.dismiss();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //dialog.dismiss();
                Log.e("PdfListFragment", "Failed to retrieve PDF file URLs from Firebase", error.toException());
            }
        });

        return view;*/

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new PdfAdapter());
        retrievePDFs();
        return view;
    }

    private void retrievePDFs() {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        storage.getReference().child("pdfs").listAll().addOnSuccessListener(listResult -> {
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
                    // Handle download failure
                    Log.e(TAG,"Error downloading files");
                });
            }
        }).addOnFailureListener(e -> { });
    }


    private class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.PdfViewHolder> {

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
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    // Handle exception
                }
            });
        }

        @Override
        public int getItemCount() {
            return pdfList.size();
        }

        private class PdfViewHolder extends RecyclerView.ViewHolder {
            TextView pdfTitle;

            PdfViewHolder(View itemView) {
                super(itemView);
                pdfTitle = itemView.findViewById(R.id.recitem_title);
            }
        }
    }
}