package com.example.uniapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.uniapp.R;
import com.example.uniapp.adapters.SpecialtiesAdapter;
import com.example.uniapp.models.Department;
import com.example.uniapp.models.Specialty;

import java.util.ArrayList;
import java.util.List;

public class SpecialtiesActivity extends AppCompatActivity {

    private List<Specialty> specialtyList;
    private RecyclerView specialtiesRecyclerView;
    private SpecialtiesAdapter specialtiesAdapter;
    private Department department;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialties);

        String departmentName = getIntent().getStringExtra("departmentName");
        textView = findViewById(R.id.specialty_text_view);
        textView.setText(departmentName);

        department = new Department(departmentName);
        setSpecialtyRecyclerView(departmentName);

        specialtiesRecyclerView = findViewById(R.id.specialty_recycler_view);
        specialtiesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        specialtiesAdapter = new SpecialtiesAdapter(getSpecialtiesForDepartment(), this);
        specialtiesRecyclerView.setAdapter(specialtiesAdapter);
    }

    // This is a dummy method that returns a list of specialties for a given department name
    private List<Specialty> getSpecialtiesForDepartment() {
        /*// You would need to implement this method to retrieve the list of specialties
        // for a given department name from your data source (database, web service, etc.)
        // For now, we'll just return a dummy list of specialties
        List<Discipline> disciplines = new ArrayList<>();
        disciplines.add(new Discipline("Discipline 1"));
        disciplines.add(new Discipline("Discipline 2"));

        List<Specialty> specialties = new ArrayList<>();
        specialties.add(new Specialty("Specialty 1", disciplines));
        specialties.add(new Specialty("Specialty 2", disciplines));
        specialties.add(new Specialty("Specialty 3", disciplines));*/

        specialtyList = new ArrayList<>();
        if (department != null && department.getSpecialties() != null) {
            specialtyList.addAll(department.getSpecialties());
        }

        return specialtyList;
    }

    private void setSpecialtyRecyclerView(String departmentName) {
        if (departmentName.equals("Кафедра диференціальних рівнянь і прикладної математики")) {
            department.setSpecialties(setMiF1());
        }
        else if (departmentName.equals("Кафедра комп’ютерних наук та інформаційних систем")) {
            department.setSpecialties(setMiF2());
        }
        else if (departmentName.equals("Кафедра математики та інформатики і методики навчання")) {
            department.setSpecialties(setMiF3());
        }
        else if (departmentName.equals("Кафедра української мови")) {
            department.setSpecialties(setFIL1());
        }
    }
    public List<Specialty> setMiF1() {
        List<Specialty> specialties= new ArrayList<>();
        specialties.add(new Specialty("113 - Прикладна математика"));
        return specialties;
    }
    public List<Specialty> setMiF2() {
        List<Specialty> specialties= new ArrayList<>();
        specialties.add(new Specialty("122 - Комп’ютерні науки"));
        specialties.add(new Specialty("126 – Інформаційні системи та технології"));
        return specialties;
    }
    public List<Specialty> setMiF3() {
        List<Specialty> specialties= new ArrayList<>();
        specialties.add(new Specialty("014.04 - Середня освіта (Математика)"));
        specialties.add(new Specialty("014.09 - Середня освіта (Інформатика)"));
        return specialties;
    }
    public List<Specialty> setMiF4() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
    public List<Specialty> setMiF5() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
    public List<Specialty> setMiF6() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }

    public List<Specialty> setFIL1() {
        List<Specialty> specialties= new ArrayList<>();
        specialties.add(new Specialty("035 Філологія"));
        return specialties;
    }
    public List<Specialty> setFIL2() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
    public List<Specialty> setFIL3() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
    public List<Specialty> setFIL4() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
    public List<Specialty> setFIL5() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
    public List<Specialty> setFIL6() {
        List<Specialty> specialties= new ArrayList<>();
        return specialties;
    }
}
