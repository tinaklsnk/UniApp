package com.example.uniapp.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Specialty implements Serializable {
    private String name;
    private List<Discipline> disciplines;

    private String path;

    public Specialty(String name, List<Discipline> disciplines, String path) {
        this.name = name;
        this.disciplines = disciplines;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public Collection<? extends Discipline> getDisciplines() {
        return disciplines;
    }

    public String getPath() {
        return path;
    }
}
