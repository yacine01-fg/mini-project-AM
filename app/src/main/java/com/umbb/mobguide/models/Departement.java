package com.umbb.mobguide.models;

import java.util.ArrayList;

public class Departement {
    private String nom;
    private String description;
    private String email;
    private String telephone;
    private ArrayList<String> specialites;

    public Departement(String nom, String description, String email, String telephone) {
        this.nom = nom;
        this.description = description;
        this.email = email;
        this.telephone = telephone;
        this.specialites = new ArrayList<>();
    }

    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }
    public ArrayList<String> getSpecialites() { return specialites; }

    public void addSpecialite(String s) { specialites.add(s); }
}