package com.example.uniapp.fragments;

import android.content.Context;
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

import com.example.uniapp.MainActivity;
import com.example.uniapp.PDFmodel;
import com.example.uniapp.R;
import com.example.uniapp.RecyclerViewAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    /*//////////////////////////////////////////////////////////////////
    private RecyclerView mRecyclerView;
    private FirebaseStorage mStorage;
    Context context;
    //////////////////////////////////////////////////////////////////*/
    DatabaseReference databaseReference;
    ValueEventListener eventListener;
    RecyclerView recyclerView;
    List<PDFmodel> dataList;
    RecyclerViewAdapter adapter;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.my_recycler_view);

        Context context = getContext();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        /*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();*/

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

        return view;
    }
}