package com.example.uniapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.uniapp.R;
import com.example.uniapp.adapters.SpecialtiesAdapter;
import com.example.uniapp.models.Discipline;
import com.example.uniapp.models.Specialty;

import java.util.ArrayList;
import java.util.List;

public class SpecialtiesActivity extends AppCompatActivity {

    private List<Specialty> specialties;
    private RecyclerView recyclerView;
    private SpecialtiesAdapter specialtiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialties);

        // Get the department name passed from the previous activity
        String departmentName = getIntent().getStringExtra("departmentName");

        // Get the list of specialties for the selected department
        // You would need to populate the list of specialties for each department in your application
        specialties = getSpecialtiesForDepartment(departmentName);

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.specialty_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter and set it to the RecyclerView
        specialtiesAdapter = new SpecialtiesAdapter(specialties, this);
        recyclerView.setAdapter(specialtiesAdapter);
    }

    // This is a dummy method that returns a list of specialties for a given department name
    private List<Specialty> getSpecialtiesForDepartment(String departmentName) {
        // You would need to implement this method to retrieve the list of specialties
        // for a given department name from your data source (database, web service, etc.)
        // For now, we'll just return a dummy list of specialties
        List<Discipline> disciplines = new ArrayList<>();
        disciplines.add(new Discipline("Discipline 1"));
        disciplines.add(new Discipline("Discipline 2"));

        List<Specialty> specialties = new ArrayList<>();
        specialties.add(new Specialty("Specialty 1", disciplines));
        specialties.add(new Specialty("Specialty 2", disciplines));
        specialties.add(new Specialty("Specialty 3", disciplines));

        return specialties;
    }
}
