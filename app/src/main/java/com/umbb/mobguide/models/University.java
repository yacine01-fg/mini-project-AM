package com.umbb.mobguide.models;

import java.io.Serializable;
import java.util.ArrayList;

public class University implements Serializable {
    private int id;
    private String name;
    private String city;
    private String description;
    private int imageResId;
    private ArrayList<Faculty> faculties;

    public University(int id, String name, String city, String description, int imageResId, ArrayList<Faculty> faculties) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.description = description;
        this.imageResId = imageResId;
        this.faculties = faculties;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCity() { return city; }
    public String getDescription() { return description; }
    public int getImageResId() { return imageResId; }
    public ArrayList<Faculty> getFaculties() { return faculties; }
}