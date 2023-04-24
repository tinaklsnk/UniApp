package com.example.uniapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.uniapp.R;
import com.example.uniapp.adapters.DepartmentsAdapter;
import com.example.uniapp.models.Department;
import com.example.uniapp.models.Faculty;

import java.util.ArrayList;
import java.util.List;

public class DepartmentsActivity extends AppCompatActivity {

    private RecyclerView departmentsList;
    private DepartmentsAdapter departmentsAdapter;
    private List<Department> listDepartments;
    private Faculty faculty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);

        Intent intent = getIntent();
        String facultyName = intent.getStringExtra("facultyName");
        faculty = new Faculty(facultyName);

        departmentsList = findViewById(R.id.departments_recycler_view);
        departmentsAdapter = new DepartmentsAdapter(getDepartments(), this);
        departmentsList.setAdapter(departmentsAdapter);
    }

    private List<Department> getDepartments() {
        listDepartments = new ArrayList<>();
        if (faculty != null && faculty.getDepartments() != null) {
            listDepartments.addAll(faculty.getDepartments());
        }
        return listDepartments;
    }
}
