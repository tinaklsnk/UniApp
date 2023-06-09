package com.example.uniapp.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uniapp.adapters.FacultiesAdapter;
import com.example.uniapp.models.Department;
import com.example.uniapp.models.Faculty;
import com.example.uniapp.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {

    private RecyclerView facultyRecyclerView;
    private FacultiesAdapter facultiesAdapter;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faculties, container, false);
        context = getContext();

        facultyRecyclerView = view.findViewById(R.id.faculty_recycler_view);
        facultiesAdapter = new FacultiesAdapter(getFaculties(), context);
        facultyRecyclerView.setAdapter(facultiesAdapter);
        facultyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    private List<Faculty> getFaculties() {
        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(new Faculty("Факультет математики та інформатики"));
        facultyList.add(new Faculty("Факультет філології"));
        facultyList.add(new Faculty("Економічний факультет"));
        facultyList.add(new Faculty("Педагогічний факультет"));
        facultyList.add(new Faculty("Факультет іноземних мов"));
        facultyList.add(new Faculty("Факультет психології"));
        facultyList.add(new Faculty("Факультет туризму"));
        facultyList.add(new Faculty("Фізико-технічний факультет"));
        facultyList.add(new Faculty("Факультет історії, політології і міжнародних відносин"));
        facultyList.add(new Faculty("Факультет природничих наук"));
        facultyList.add(new Faculty("Факультет фізичного виховання і спорту"));

        return facultyList;
    }
}
