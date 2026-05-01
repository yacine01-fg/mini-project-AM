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
        // Logo is kept as resource ID as requested "EXEPTE THE LOGO"
        Universite umbb = new Universite(1, "UMBB", "Université M'Hamed Bougara de Boumerdès", "Boumerdès", R.drawable.logo_mobguide);

        Faculte fs = new Faculte(
                "Faculté des Sciences",
                "The Faculty of Sciences at UMBB offers diverse programs in fundamental and applied sciences, fostering research and innovation.",
                "fs@univ-boumerdes.dz", "+213 24 81 64 15", "Boumerdès", 36.7510, 3.4780, 
                "https://upload.wikimedia.org/wikipedia/commons/d/d7/Boumerd%C3%A8s_University.png");
        
        fs.addDepartement(new Departement("Informatique", "Study of computational systems, software development, and AI.", "info@univ-boumerdes.dz", "+213 24 81 64 15", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/LogoUPSUD.png/1280px-LogoUPSUD.png"));
        fs.addDepartement(new Departement("Mathématiques", "Exploring abstract structures and mathematical modeling.", "math@univ-boumerdes.dz", "+213 24 81 64 15", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/CMAP_-_Centre_de_Math%C3%A9matiques_Appliqu%C3%A9es_de_l%27Ecole_polytechnique.jpg/1280px-CMAP_-_Centre_de_Math%C3%A9matiques_Appliqu%C3%A9es_de_l%27Ecole_polytechnique.jpg"));
        fs.addDepartement(new Departement("Physique", "Understanding the fundamental laws of the universe.", "phys@univ-boumerdes.dz", "+213 24 81 64 15", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Tomorrows_Man_v1_n3_1953.pdf/page1-500px-Tomorrows_Man_v1_n3_1953.pdf.jpg"));
        fs.addDepartement(new Departement("Chimie", "Research in chemical reactions and material sciences.", "chimie@univ-boumerdes.dz", "+213 24 81 64 15", "https://upload.wikimedia.org/wikipedia/commons/1/1e/Facade_ENSCP.png"));
        fs.addDepartement(new Departement("SNV", "Sciences of Nature and Life, focusing on biology and environment.", "snv@univ-boumerdes.dz", "+213 24 81 64 15", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/Sin_Nombre_virus_Hanta_TEM_1137_lores.jpg/1280px-Sin_Nombre_virus_Hanta_TEM_1137_lores.jpg"));
        facultes.add(fs);

        Faculte fsi = new Faculte(
                "Faculté des Sciences de l'Ingénieur",
                "FSI is dedicated to engineering excellence, training professionals in various technical domains.",
                "fsi@univ-boumerdes.dz", "+213 24 81 64 10", "Boumerdès", 36.7510, 3.4780, 
                "https://upload.wikimedia.org/wikipedia/commons/d/d7/Boumerd%C3%A8s_University.png");
        
        fsi.addDepartement(new Departement("Génie Civil", "Infrastructure design and construction management.", "civil@univ-boumerdes.dz", "+213 24 81 64 10", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/CBQreview.jpeg/1280px-CBQreview.jpeg"));
        fsi.addDepartement(new Departement("Génie Mécanique", "Mechanical design and industrial manufacturing.", "mecanique@univ-boumerdes.dz", "+213 24 81 64 10", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Cit%C3%A9_scientifique_Lille_Nord_de_France.jpg/1280px-Cit%C3%A9_scientifique_Lille_Nord_de_France.jpg"));
        fsi.addDepartement(new Departement("Génie Electrique", "Power systems, electronics, and control engineering.", "electrique@univ-boumerdes.dz", "+213 24 81 64 10", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Port_and_lighthouse_overnight_storm_with_lightning_in_Port-la-Nouvelle.jpg/1280px-Port_and_lighthouse_overnight_storm_with_lightning_in_Port-la-Nouvelle.jpg"));
        fsi.addDepartement(new Departement("Génie des Procédés", "Process engineering and industrial chemistry.", "procedes@univ-boumerdes.dz", "+213 24 81 64 10", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Cit%C3%A9_scientifique_Lille_Nord_de_France.jpg/1280px-Cit%C3%A9_scientifique_Lille_Nord_de_France.jpg"));
        fsi.addDepartement(new Departement("Architecture", "Integrating art and engineering in building design.", "archi@univ-boumerdes.dz", "+213 24 81 64 10", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/University_of_Newcastle_Coat_of_Arms.svg/1280px-University_of_Newcastle_Coat_of_Arms.svg.png"));
        facultes.add(fsi);

        Faculte fhc = new Faculte(
                "Faculté des Hydrocarbures et de la Chimie",
                "A leading faculty in Africa for oil and gas education and research.",
                "fhc@univ-boumerdes.dz", "+213 24 81 64 30", "Boumerdès", 36.7498, 3.4770, 
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Boumerd%C3%A8s.JPG/1280px-Boumerd%C3%A8s.JPG");
        
        fhc.addDepartement(new Departement("Génie des Hydrocarbures", "Exploration, drilling, and production technologies.", "hydro@univ-boumerdes.dz", "+213 24 81 64 30", "https://images.unsplash.com/photo-1454165833267-028cc2402f10?q=80&w=1000&auto=format&fit=crop"));
        fhc.addDepartement(new Departement("Génie Chimique", "Refining and petrochemical industry processes.", "chimique@univ-boumerdes.dz", "+213 24 81 64 30", "https://images.unsplash.com/photo-1581093458791-9f3c3250bb8b?q=80&w=1000&auto=format&fit=crop"));
        fhc.addDepartement(new Departement("Génie des Réservoirs", "Analysis and management of underground oil and gas reservoirs.", "reservoirs@univ-boumerdes.dz", "+213 24 81 64 30", "https://images.unsplash.com/photo-1543326727-cf6c39e8f84c?q=80&w=1000&auto=format&fit=crop"));
        facultes.add(fhc);

        Faculte fsecsg = new Faculte(
                "Faculté des Sciences Economiques",
                "Preparing future leaders in economics, business, and management.",
                "fsecsg@univ-boumerdes.dz", "+213 24 81 64 40", "Boumerdès", 36.7500, 3.4700, 
                "https://images.unsplash.com/photo-1454165833267-028cc2402f10?q=80&w=1000&auto=format&fit=crop");
        
        fsecsg.addDepartement(new Departement("Sciences Economiques", "Study of markets, policy, and global economics.", "eco@univ-boumerdes.dz", "+213 24 81 64 40", "https://images.unsplash.com/photo-1611974717482-9825d300b65a?q=80&w=1000&auto=format&fit=crop"));
        fsecsg.addDepartement(new Departement("Sciences Commerciales", "Marketing, trade, and business strategy.", "commerce@univ-boumerdes.dz", "+213 24 81 64 40", "https://images.unsplash.com/photo-1460925895917-afdab827c52f?q=80&w=1000&auto=format&fit=crop"));
        fsecsg.addDepartement(new Departement("Sciences de Gestion", "Management, human resources, and organizational behavior.", "gestion@univ-boumerdes.dz", "+213 24 81 64 40", "https://images.unsplash.com/photo-1450101499163-c8848c66ca85?q=80&w=1000&auto=format&fit=crop"));
        facultes.add(fsecsg);

        Faculte ft = new Faculte(
                "Faculté de Technologie",
                "Focused on advanced technologies, automation, and telecommunications.",
                "ft@univ-boumerdes.dz", "+213 24 81 64 50", "Boumerdès", 36.7520, 3.4790, 
                "https://images.unsplash.com/photo-1581092921461-eab62e97a780?q=80&w=1000&auto=format&fit=crop");
        
        ft.addDepartement(new Departement("Génie Industriel", "Optimization of complex processes and systems.", "industriel@univ-boumerdes.dz", "+213 24 81 64 50", "https://images.unsplash.com/photo-1504917595217-d4dc5ebe6122?q=80&w=1000&auto=format&fit=crop"));
        ft.addDepartement(new Departement("Electronique", "Advanced electronic systems and circuit design.", "elec@univ-boumerdes.dz", "+213 24 81 64 50", "https://images.unsplash.com/photo-1517077304055-6e89abbf09b0?q=80&w=1000&auto=format&fit=crop"));
        ft.addDepartement(new Departement("Télécommunications", "Network infrastructure and wireless communication.", "telecom@univ-boumerdes.dz", "+213 24 81 64 50", "https://images.unsplash.com/photo-1520867639452-b446bb3e9dc4?q=80&w=1000&auto=format&fit=crop"));
        ft.addDepartement(new Departement("Automatique", "Control systems and robotics.", "autom@univ-boumerdes.dz", "+213 24 81 64 50", "https://images.unsplash.com/photo-1563206767-5b18f218e8de?q=80&w=1000&auto=format&fit=crop"));
        facultes.add(ft);

        Faculte fdsp = new Faculte(
                "Faculté de Droit",
                "Training experts in law and political sciences.",
                "fdsp@univ-boumerdes.dz", "+213 24 81 64 60", "Boumerdès", 36.7530, 3.4800, 
                "https://images.unsplash.com/photo-1589829545856-d10d557cf95f?q=80&w=1000&auto=format&fit=crop");
        
        fdsp.addDepartement(new Departement("Droit Privé", "Legal relations between individuals and organizations.", "prive@univ-boumerdes.dz", "+213 24 81 64 60", "https://images.unsplash.com/photo-1505664194779-8beaceb93744?q=80&w=1000&auto=format&fit=crop"));
        fdsp.addDepartement(new Departement("Droit Public", "State-related law and public administration.", "public@univ-boumerdes.dz", "+213 24 81 64 60", "https://images.unsplash.com/photo-1423592707957-3b212afa6733?q=80&w=1000&auto=format&fit=crop"));
        fdsp.addDepartement(new Departement("Sciences Politiques", "Analysis of political systems and governance.", "po@univ-boumerdes.dz", "+213 24 81 64 60", "https://images.unsplash.com/photo-1529107386315-e1a2ed48a620?q=80&w=1000&auto=format&fit=crop"));
        facultes.add(fdsp);

        for (Faculte f : facultes) {
            umbb.addFaculte(f);
        }
        universites.add(umbb);
    }
}
