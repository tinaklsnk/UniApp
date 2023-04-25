package com.example.uniapp.models;

import com.example.uniapp.models.Department;

import java.util.List;

public class Faculty {
    private String name;
    private List<Department> departments;

    public Faculty(String name/*, List<Department> departments*/) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}

