package com.umbb.mobguide.models;

import java.io.Serializable;

public class Department implements Serializable {
    private String name;
    private String specialties;
    private String contactEmail;
    private String contactPhone;
    private String locationUrl;

    public Department(String name, String specialties, String contactEmail, String contactPhone, String locationUrl) {
        this.name = name;
        this.specialties = specialties;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.locationUrl = locationUrl;
    }

    public String getName() { return name; }
    public String getSpecialties() { return specialties; }
    public String getContactEmail() { return contactEmail; }
    public String getContactPhone() { return contactPhone; }
    public String getLocationUrl() { return locationUrl; }
}