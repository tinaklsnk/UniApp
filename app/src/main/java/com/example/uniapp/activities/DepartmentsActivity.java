package com.example.uniapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.uniapp.R;
import com.example.uniapp.adapters.DepartmentsAdapter;
import com.example.uniapp.models.Department;
import com.example.uniapp.models.Faculty;

import java.util.ArrayList;
import java.util.List;

public class DepartmentsActivity extends AppCompatActivity {

    private RecyclerView departmentsRecyclerView;
    private DepartmentsAdapter departmentsAdapter;
    private List<Department> departmentList;
    private Faculty faculty;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);

        Intent intent = getIntent();
        String facultyName = intent.getStringExtra("facultyName");

        faculty = new Faculty(facultyName);
        setDepartmentsRecyclerView(facultyName);

        textView = findViewById(R.id.department_text_view);
        textView.setText(facultyName);

        departmentsRecyclerView = findViewById(R.id.department_recycler_view);
        departmentsAdapter = new DepartmentsAdapter(getDepartments(), this);
        departmentsRecyclerView.setAdapter(departmentsAdapter);
        departmentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<Department> getDepartments() {
        departmentList = new ArrayList<>();
        if (faculty != null && faculty.getDepartments() != null) {
            departmentList.addAll(faculty.getDepartments());
        }
        return departmentList;
    }

    private void setDepartmentsRecyclerView(String facultyName) {
        if (facultyName.equals("Факультет математики та інформатики")) {
            faculty.setDepartments(setMIFdepartments());
        } else if (facultyName.equals("Факультет філології")) {
            faculty.setDepartments(setFILdepartments());
        }
    }

    public List<Department> setMIFdepartments() {
        List<Department> MIFdepartments= new ArrayList<>();
        MIFdepartments.add(new Department("Кафедра диференціальних рівнянь і прикладної математики"));
        MIFdepartments.add(new Department("Кафедра комп’ютерних наук та інформаційних систем"));
        MIFdepartments.add(new Department("Кафедра математики та інформатики і методики навчання"));
        MIFdepartments.add(new Department("Кафедра алгебри та геометрії"));
        MIFdepartments.add(new Department("Кафедра інформаційних технологій"));
        return MIFdepartments;
    }

    public List<Department> setFILdepartments() {
        List<Department> FILdepartments= new ArrayList<>();
        FILdepartments.add(new Department("Кафедра української мови"));
        FILdepartments.add(new Department("Кафедра української літератури"));
        FILdepartments.add(new Department("Кафедра світової літератури і порівняльного літературознавства"));
        FILdepartments.add(new Department("Кафедра слов’янських мов"));
        FILdepartments.add(new Department("Кафедра загального та германського мовознавства"));
        FILdepartments.add(new Department("Кафедра журналістики"));
        return FILdepartments;
    }


}
