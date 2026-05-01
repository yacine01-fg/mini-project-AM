package com.umbb.mobguide.models;

import com.umbb.mobguide.R;
import java.util.ArrayList;

/**
 * Single source of truth for all University, Faculty, and Department data.
 */
public class DataRepository {
    private static DataRepository instance;
    private final ArrayList<University> universities;

    private DataRepository() {
        universities = new ArrayList<>();
        initData();
    }

    public static synchronized DataRepository getInstance() {
        if (instance == null) {
            instance = new DataRepository();
        }
        return instance;
    }

    private void initData() {
        // 1. UMBB - Université M'Hamed Bougara de Boumerdès
        ArrayList<Faculty> umbbFaculties = new ArrayList<>();
        
        // FS
        ArrayList<Department> fsDepts = new ArrayList<>();
        fsDepts.add(new Department("Informatique", "Licence / Master / Doctorat", "fs_info@umbb.dz", "024 79 52 01", "geo:36.762,3.475"));
        fsDepts.add(new Department("Mathématiques", "Licence / Master", "fs_math@umbb.dz", "024 79 52 02", "geo:36.762,3.475"));
        fsDepts.add(new Department("Physique", "Licence / Master", "fs_phys@umbb.dz", "024 79 52 03", "geo:36.762,3.475"));
        fsDepts.add(new Department("Chimie", "Licence / Master", "fs_chem@umbb.dz", "024 79 52 04", "geo:36.762,3.475"));
        fsDepts.add(new Department("SNV", "Licence / Master", "fs_snv@umbb.dz", "024 79 52 05", "geo:36.762,3.475"));
        umbbFaculties.add(new Faculty("Faculté des Sciences (FS)", R.drawable.img_science, fsDepts));

        // FSI
        ArrayList<Department> fsiDepts = new ArrayList<>();
        fsiDepts.add(new Department("Génie Civil", "Licence / Master", "fsi_gc@umbb.dz", "024 79 52 10", "geo:36.762,3.475"));
        fsiDepts.add(new Department("Mécanique", "Licence / Master", "fsi_mec@umbb.dz", "024 79 52 11", "geo:36.762,3.475"));
        fsiDepts.add(new Department("Electrique", "Licence / Master", "fsi_elec@umbb.dz", "024 79 52 12", "geo:36.762,3.475"));
        fsiDepts.add(new Department("Procédés", "Licence / Master", "fsi_proc@umbb.dz", "024 79 52 13", "geo:36.762,3.475"));
        fsiDepts.add(new Department("Architecture", "Licence / Master", "fsi_arch@umbb.dz", "024 79 52 14", "geo:36.762,3.475"));
        umbbFaculties.add(new Faculty("Faculté des Sciences de l'Ingénieur (FSI)", R.drawable.img_tech, fsiDepts));

        // FHC
        ArrayList<Department> fhcDepts = new ArrayList<>();
        fhcDepts.add(new Department("Génie des Hydrocarbures", "Licence / Master", "fhc@umbb.dz", "024 79 52 20", "geo:36.762,3.475"));
        umbbFaculties.add(new Faculty("Faculté des Hydrocarbures et de la Chimie (FHC)", R.drawable.img_tech, fhcDepts));

        universities.add(new University(1, 
            "Université M'Hamed Bougara de Boumerdès", 
            "Boumerdès", 
            "Fondée en 1998, l'UMBB est une université de premier plan en Algérie.", 
            R.drawable.img_umbb, 
            umbbFaculties));

        // 2. USTHB - Université des Sciences et de la Technologie Houari Boumediene
        ArrayList<Faculty> usthbFaculties = new ArrayList<>();
        ArrayList<Department> usthbInfo = new ArrayList<>();
        usthbInfo.add(new Department("Informatique", "L/M/D", "info@usthb.dz", "021 24 79 12", "geo:36.711,3.183"));
        usthbFaculties.add(new Faculty("Faculté d'Informatique", R.drawable.img_usthb, usthbInfo));
        
        ArrayList<Department> usthbMath = new ArrayList<>();
        usthbMath.add(new Department("Mathématiques", "L/M/D", "math@usthb.dz", "021 24 79 13", "geo:36.711,3.183"));
        usthbFaculties.add(new Faculty("Faculté de Mathématiques", R.drawable.img_usthb, usthbMath));

        universities.add(new University(2, 
            "USTHB - Houari Boumediene", 
            "Alger", 
            "L'USTHB est l'une des plus grandes universités technologiques d'Afrique.", 
            R.drawable.img_usthb, 
            usthbFaculties));

        // 3. Université d'Alger 1
        ArrayList<Faculty> alger1Faculties = new ArrayList<>();
        ArrayList<Department> algerDroit = new ArrayList<>();
        algerDroit.add(new Department("Droit", "L/M/D", "droit@univ-alger.dz", "021 63 11 11", "geo:36.772,3.058"));
        alger1Faculties.add(new Faculty("Faculté de Droit", R.drawable.img_alger1, algerDroit));

        universities.add(new University(3, 
            "Université d'Alger 1", 
            "Alger", 
            "L'université historique d'Alger, centre d'excellence académique.", 
            R.drawable.img_alger1, 
            alger1Faculties));
    }

    public ArrayList<University> getUniversities() {
        return universities;
    }

    public University getUniversityByName(String name) {
        for (University u : universities) {
            if (u.getName().equalsIgnoreCase(name)) return u;
        }
        return null;
    }
}