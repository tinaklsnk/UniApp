package com.example.uniapp;

import java.util.List;

public class Specialty {
    private String name;
    private List<Discipline> disciplines;

    public Specialty(String name, List<Discipline> disciplines) {
        this.name = name;
        this.disciplines = disciplines;
    }

    public String getName() {
        return name;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }
}
