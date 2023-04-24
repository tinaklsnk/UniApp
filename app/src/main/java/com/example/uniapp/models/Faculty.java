package com.example.uniapp;

import java.util.List;

public class Faculty {
    private String name;
    private List<Department> departments;

    public Faculty(String name/*, List<Department> departments*/) {
        this.name = name;
        //this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}

