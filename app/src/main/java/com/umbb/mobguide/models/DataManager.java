package com.umbb.mobguide.models;

import java.util.ArrayList;
import com.umbb.mobguide.R;

public class DataManager {

    private static DataManager instance;
    private ArrayList<Faculte> facultes;
    private ArrayList<Universite> universites;

    private DataManager() {
        facultes = new ArrayList<>();
        universites = new ArrayList<>();
        initData();
    }

    public static DataManager getInstance() {
        if (instance == null) instance = new DataManager();
        return instance;
    }

    public ArrayList<Faculte> getFacultes() { return facultes; }

    public ArrayList<Universite> getUniversites() {
        return universites;
    }

    public Universite getUniversiteById(int id) {
        for (Universite u : universites) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    private void initData() {
        Universite umbb = new Universite(1, "UMBB", "Université M'Hamed Bougara de Boumerdès", "Boumerdès", R.drawable.logo);

        Faculte fs = new Faculte(
                "Faculté des Sciences",
                "The Faculty of Sciences at UMBB offers diverse programs in fundamental and applied sciences, fostering research and innovation.",
                "fs@univ-boumerdes.dz", "+213 24 81 64 15", "Boumerdès", 36.7510, 3.4780, R.drawable.img_science);
        fs.addDepartement(new Departement("Informatique", "Study of computational systems, software development, and AI.", "info@univ-boumerdes.dz", "+213 24 81 64 15", R.drawable.img_tech));
        fs.addDepartement(new Departement("Mathématiques", "Exploring abstract structures and mathematical modeling.", "math@univ-boumerdes.dz", "+213 24 81 64 15", R.drawable.img_science));
        fs.addDepartement(new Departement("Physique", "Understanding the fundamental laws of the universe.", "phys@univ-boumerdes.dz", "+213 24 81 64 15", R.drawable.img_science));
        fs.addDepartement(new Departement("Chimie", "Research in chemical reactions and material sciences.", "chimie@univ-boumerdes.dz", "+213 24 81 64 15", R.drawable.img_science));
        fs.addDepartement(new Departement("SNV", "Sciences of Nature and Life, focusing on biology and environment.", "snv@univ-boumerdes.dz", "+213 24 81 64 15", R.drawable.img_science));
        facultes.add(fs);

        Faculte fsi = new Faculte(
                "Faculté des Sciences de l'Ingénieur",
                "FSI is dedicated to engineering excellence, training professionals in various technical domains.",
                "fsi@univ-boumerdes.dz", "+213 24 81 64 10", "Boumerdès", 36.7510, 3.4780, R.drawable.img_tech);
        fsi.addDepartement(new Departement("Génie Civil", "Infrastructure design and construction management.", "civil@univ-boumerdes.dz", "+213 24 81 64 10", R.drawable.img_tech));
        fsi.addDepartement(new Departement("Génie Mécanique", "Mechanical design and industrial manufacturing.", "mecanique@univ-boumerdes.dz", "+213 24 81 64 10", R.drawable.img_tech));
        fsi.addDepartement(new Departement("Génie Electrique", "Power systems, electronics, and control engineering.", "electrique@univ-boumerdes.dz", "+213 24 81 64 10", R.drawable.img_tech));
        fsi.addDepartement(new Departement("Génie des Procédés", "Process engineering and industrial chemistry.", "procedes@univ-boumerdes.dz", "+213 24 81 64 10", R.drawable.img_tech));
        fsi.addDepartement(new Departement("Architecture", "Integrating art and engineering in building design.", "archi@univ-boumerdes.dz", "+213 24 81 64 10", R.drawable.img_tech));
        facultes.add(fsi);

        Faculte fhc = new Faculte(
                "Faculté des Hydrocarbures et de la Chimie",
                "A leading faculty in Africa for oil and gas education and research.",
                "fhc@univ-boumerdes.dz", "+213 24 81 64 30", "Boumerdès", 36.7498, 3.4770, R.drawable.faculte_hydrocarbures_chimie);
        fhc.addDepartement(new Departement("Génie des Hydrocarbures", "Exploration, drilling, and production technologies.", "hydro@univ-boumerdes.dz", "+213 24 81 64 30", R.drawable.img_umbb));
        fhc.addDepartement(new Departement("Génie Chimique", "Refining and petrochemical industry processes.", "chimique@univ-boumerdes.dz", "+213 24 81 64 30", R.drawable.img_umbb));
        fhc.addDepartement(new Departement("Génie des Réservoirs", "Analysis and management of underground oil and gas reservoirs.", "reservoirs@univ-boumerdes.dz", "+213 24 81 64 30", R.drawable.img_umbb));
        facultes.add(fhc);

        Faculte fsecsg = new Faculte(
                "Faculté des Sciences Economiques",
                "Preparing future leaders in economics, business, and management.",
                "fsecsg@univ-boumerdes.dz", "+213 24 81 64 40", "Boumerdès", 36.7500, 3.4700, R.drawable.img_alger1);
        fsecsg.addDepartement(new Departement("Sciences Economiques", "Study of markets, policy, and global economics.", "eco@univ-boumerdes.dz", "+213 24 81 64 40", R.drawable.img_alger1));
        fsecsg.addDepartement(new Departement("Sciences Commerciales", "Marketing, trade, and business strategy.", "commerce@univ-boumerdes.dz", "+213 24 81 64 40", R.drawable.img_alger1));
        fsecsg.addDepartement(new Departement("Sciences de Gestion", "Management, human resources, and organizational behavior.", "gestion@univ-boumerdes.dz", "+213 24 81 64 40", R.drawable.img_alger1));
        facultes.add(fsecsg);

        Faculte ft = new Faculte(
                "Faculté de Technologie",
                "Focused on advanced technologies, automation, and telecommunications.",
                "ft@univ-boumerdes.dz", "+213 24 81 64 50", "Boumerdès", 36.7520, 3.4790, R.drawable.faculte_technologie);
        ft.addDepartement(new Departement("Génie Industriel", "Optimization of complex processes and systems.", "industriel@univ-boumerdes.dz", "+213 24 81 64 50", R.drawable.img_tech));
        ft.addDepartement(new Departement("Electronique", "Advanced electronic systems and circuit design.", "elec@univ-boumerdes.dz", "+213 24 81 64 50", R.drawable.img_tech));
        ft.addDepartement(new Departement("Télécommunications", "Network infrastructure and wireless communication.", "telecom@univ-boumerdes.dz", "+213 24 81 64 50", R.drawable.img_tech));
        ft.addDepartement(new Departement("Automatique", "Control systems and robotics.", "autom@univ-boumerdes.dz", "+213 24 81 64 50", R.drawable.img_tech));
        facultes.add(ft);

        Faculte fdsp = new Faculte(
                "Faculté de Droit",
                "Training experts in law and political sciences.",
                "fdsp@univ-boumerdes.dz", "+213 24 81 64 60", "Boumerdès", 36.7530, 3.4800, R.drawable.img_alger1);
        fdsp.addDepartement(new Departement("Droit Privé", "Legal relations between individuals and organizations.", "prive@univ-boumerdes.dz", "+213 24 81 64 60", R.drawable.img_alger1));
        fdsp.addDepartement(new Departement("Droit Public", "State-related law and public administration.", "public@univ-boumerdes.dz", "+213 24 81 64 60", R.drawable.img_alger1));
        fdsp.addDepartement(new Departement("Sciences Politiques", "Analysis of political systems and governance.", "po@univ-boumerdes.dz", "+213 24 81 64 60", R.drawable.img_alger1));
        facultes.add(fdsp);

        for (Faculte f : facultes) {
            umbb.addFaculte(f);
        }
        universites.add(umbb);
    }
}