package com.example.uniapp.fragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uniapp.pdfs.PDFmodel;
import com.example.uniapp.pdfs.PdfAdapter;
import com.example.uniapp.R;
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

        PdfAdapter adapter = new PdfAdapter(pdfList, getContext());
        recyclerView.setAdapter(adapter);

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



}