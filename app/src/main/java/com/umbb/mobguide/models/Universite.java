package com.umbb.mobguide.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Universite implements Serializable {
    private int id;
    private String nom;
    private String description;
    private String lieu;
    private int imageResId;
    private ArrayList<Faculte> facultes;

    public Universite(int id, String nom, String description, String lieu, int imageResId) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.lieu = lieu;
        this.imageResId = imageResId;
        this.facultes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getLieu() {
        return lieu;
    }

    public int getImageResId() {
        return imageResId;
    }

    public ArrayList<Faculte> getFacultes() {
        return facultes;
    }

    public void addFaculte(Faculte faculte) {
        this.facultes.add(faculte);
    }
}
