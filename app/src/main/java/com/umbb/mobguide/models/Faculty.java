package com.umbb.mobguide.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Faculty implements Serializable {
    private String name;
    private String imageUrl;
    private int imageResId;
    private ArrayList<Department> departments;

    public Faculty(String name, int imageResId, ArrayList<Department> departments) {
        this.name = name;
        this.imageResId = imageResId;
        this.departments = departments;
    }

    public Faculty(String name, String imageUrl, ArrayList<Department> departments) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.departments = departments;
    }

    public String getName() { return name; }
    public String getImageUrl() { return imageUrl; }
    public int getImageResId() { return imageResId; }
    public ArrayList<Department> getDepartments() { return departments; }
    public int getDepartmentCount() { return departments != null ? departments.size() : 0; }
}