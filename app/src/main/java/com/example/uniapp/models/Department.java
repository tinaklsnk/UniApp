package com.example.uniapp.models;

import java.util.List;

public class Department {
    private String name;
    private List<Specialty> specialties;

    public Department(String name/*, List<Specialty> specialties*/) {
        this.name = name;
        this.specialties = specialties;
    }

    public String getName() {
        return name;
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }
}

