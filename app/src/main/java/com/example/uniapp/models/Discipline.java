package com.example.uniapp.models;

import java.io.Serializable;

public class Discipline implements Serializable {
    private String name;

    public Discipline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

