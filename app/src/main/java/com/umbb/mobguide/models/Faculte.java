package com.umbb.mobguide.models;

import java.util.ArrayList;

public class Faculte {
    private String nom;
    private String description;
    private String email;
    private String telephone;
    private String adresse;
    private double latitude;
    private double longitude;
    private int imageResId;
    private ArrayList<Departement> departements;

    public Faculte(String nom, String description, String email, String telephone, String adresse, double latitude, double longitude, int imageResId) {
        this.nom = nom;
        this.description = description;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageResId = imageResId;
        this.departements = new ArrayList<>();
    }

    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }
    public String getAdresse() { return adresse; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public int getImageResId() { return imageResId; }
    public ArrayList<Departement> getDepartements() { return departements; }

    public void addDepartement(Departement d) {
        departements.add(d);
    }
}
