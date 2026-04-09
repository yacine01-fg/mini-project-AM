package com.umbb.mobguide.models;

import java.util.ArrayList;

public class DataManager {

    private static DataManager instance;
    private ArrayList<Faculte> facultes;

    private DataManager() {
        facultes = new ArrayList<>();
        initData();
    }

    public static DataManager getInstance() {
        if (instance == null) instance = new DataManager();
        return instance;
    }

    public ArrayList<Faculte> getFacultes() { return facultes; }

    private void initData() {

        // ─── Faculté des Sciences ───────────────────────────────────────────
        Faculte fsi = new Faculte(
                "Faculté des Sciences",
                "La Faculté des Sciences de l'UMBB propose des formations en informatique, mathématiques, " +
                        "physique et chimie. Elle forme des ingénieurs et des chercheurs capables de répondre aux " +
                        "besoins du marché national et international.",
                "fsi@univ-boumerdes.dz",
                "+213 24 81 64 10",
                "Avenue de l'Indépendance, Boumerdès, Algérie",
                36.7510, 3.4780
        );

        Departement dInfo = new Departement(
                "Département Informatique",
                "Le département forme des spécialistes en développement logiciel, réseaux, intelligence " +
                        "artificielle et systèmes d'information.",
                "info@univ-boumerdes.dz",
                "+213 24 81 64 11"
        );
        dInfo.addSpecialite("Licence SI (Systèmes Informatiques)");
        dInfo.addSpecialite("Licence ISIL (Ingénierie des Systèmes d'Information et Logiciel)");
        dInfo.addSpecialite("Master IA (Intelligence Artificielle)");
        dInfo.addSpecialite("Master Réseaux & Systèmes Distribués");
        fsi.addDepartement(dInfo);

        Departement dMath = new Departement(
                "Département Mathématiques",
                "Formations en mathématiques pures et appliquées, statistiques et probabilités.",
                "maths@univ-boumerdes.dz",
                "+213 24 81 64 12"
        );
        dMath.addSpecialite("Licence Mathématiques");
        dMath.addSpecialite("Master Mathématiques Appliquées");
        dMath.addSpecialite("Master Statistiques");
        fsi.addDepartement(dMath);

        Departement dPhys = new Departement(
                "Département Physique",
                "Enseignement de la physique théorique, expérimentale et de la physique des matériaux.",
                "physique@univ-boumerdes.dz",
                "+213 24 81 64 13"
        );
        dPhys.addSpecialite("Licence Physique");
        dPhys.addSpecialite("Master Physique des Matériaux");
        dPhys.addSpecialite("Master Physique Théorique");
        fsi.addDepartement(dPhys);

        Departement dChim = new Departement(
                "Département Chimie",
                "Formation en chimie analytique, organique et inorganique.",
                "chimie@univ-boumerdes.dz",
                "+213 24 81 64 14"
        );
        dChim.addSpecialite("Licence Chimie");
        dChim.addSpecialite("Master Chimie Analytique");
        fsi.addDepartement(dChim);

        facultes.add(fsi);

        // ─── Faculté de Technologie ─────────────────────────────────────────
        Faculte ftech = new Faculte(
                "Faculté de Technologie",
                "La Faculté de Technologie offre des formations d'excellence en génie civil, génie mécanique, " +
                        "génie électrique et génie des procédés. Elle est reconnue pour la qualité de ses laboratoires " +
                        "et de ses programmes de recherche.",
                "ftech@univ-boumerdes.dz",
                "+213 24 81 64 20",
                "Avenue de l'Indépendance, Boumerdès, Algérie",
                36.7525, 3.4795
        );

        Departement dGC = new Departement(
                "Département Génie Civil",
                "Formation en construction, structures, hydraulique et géotechnique.",
                "gc@univ-boumerdes.dz",
                "+213 24 81 64 21"
        );
        dGC.addSpecialite("Licence Génie Civil");
        dGC.addSpecialite("Master Structures");
        dGC.addSpecialite("Master Hydraulique");
        ftech.addDepartement(dGC);

        Departement dGM = new Departement(
                "Département Génie Mécanique",
                "Formation en mécanique, construction mécanique, thermodynamique et fabrication.",
                "gm@univ-boumerdes.dz",
                "+213 24 81 64 22"
        );
        dGM.addSpecialite("Licence Génie Mécanique");
        dGM.addSpecialite("Master Construction Mécanique");
        ftech.addDepartement(dGM);

        Departement dGE = new Departement(
                "Département Génie Électrique",
                "Formation en électronique, automatique, électrotechnique et télécommunications.",
                "ge@univ-boumerdes.dz",
                "+213 24 81 64 23"
        );
        dGE.addSpecialite("Licence Électronique");
        dGE.addSpecialite("Licence Électrotechnique");
        dGE.addSpecialite("Master Automatique");
        dGE.addSpecialite("Master Télécommunications");
        ftech.addDepartement(dGE);

        Departement dGP = new Departement(
                "Département Génie des Procédés",
                "Formation en procédés chimiques, génie pétrolier et environnement industriel.",
                "gp@univ-boumerdes.dz",
                "+213 24 81 64 24"
        );
        dGP.addSpecialite("Licence Génie des Procédés");
        dGP.addSpecialite("Master Génie Pétrolier");
        ftech.addDepartement(dGP);

        facultes.add(ftech);

        // ─── Faculté des Hydrocarbures ──────────────────────────────────────
        Faculte fhyd = new Faculte(
                "Faculté des Hydrocarbures et de la Chimie",
                "Spécialisée dans les formations liées à l'industrie pétrolière et gazière, cette faculté " +
                        "est un partenaire stratégique de Sonatrach et des grandes entreprises énergétiques. " +
                        "Elle propose des masters en forage, raffinage et pétrochimie.",
                "fhc@univ-boumerdes.dz",
                "+213 24 81 64 30",
                "Avenue de l'Indépendance, Boumerdès, Algérie",
                36.7498, 3.4770
        );

        Departement dFG = new Departement(
                "Département Forage et Gisements",
                "Formation spécialisée en exploration, forage et exploitation des gisements pétroliers.",
                "forage@univ-boumerdes.dz",
                "+213 24 81 64 31"
        );
        dFG.addSpecialite("Licence Géologie Pétrolière");
        dFG.addSpecialite("Master Forage");
        dFG.addSpecialite("Master Gisements");
        fhyd.addDepartement(dFG);

        Departement dTR = new Departement(
                "Département Transport et Raffinage",
                "Formation en raffinage du pétrole, transport par canalisation et stockage.",
                "raffinage@univ-boumerdes.dz",
                "+213 24 81 64 32"
        );
        dTR.addSpecialite("Licence Transport des Hydrocarbures");
        dTR.addSpecialite("Master Raffinage");
        fhyd.addDepartement(dTR);

        Departement dPetro = new Departement(
                "Département Pétrochimie",
                "Formation en procédés pétrochimiques et industrie chimique liée aux hydrocarbures.",
                "petrochimie@univ-boumerdes.dz",
                "+213 24 81 64 33"
        );
        dPetro.addSpecialite("Licence Pétrochimie");
        dPetro.addSpecialite("Master Pétrochimie & Polymères");
        fhyd.addDepartement(dPetro);

        facultes.add(fhyd);

        // ─── Faculté des Sciences Économiques ──────────────────────────────
        Faculte feco = new Faculte(
                "Faculté des Sciences Économiques, Commerciales et des Sciences de Gestion",
                "Cette faculté propose des formations en économie, commerce international, comptabilité " +
                        "et management. Ses diplômés intègrent les entreprises publiques et privées ainsi que les " +
                        "administrations de l'État.",
                "fsecsg@univ-boumerdes.dz",
                "+213 24 81 64 40",
                "Avenue de l'Indépendance, Boumerdès, Algérie",
                36.7535, 3.4760
        );

        Departement dEco = new Departement(
                "Département Sciences Économiques",
                "Formation en macroéconomie, microéconomie, économétrie et développement économique.",
                "eco@univ-boumerdes.dz",
                "+213 24 81 64 41"
        );
        dEco.addSpecialite("Licence Économie");
        dEco.addSpecialite("Master Économie Internationale");
        dEco.addSpecialite("Master Finance");
        feco.addDepartement(dEco);

        Departement dCom = new Departement(
                "Département Sciences Commerciales",
                "Formation en marketing, commerce international et management commercial.",
                "commerce@univ-boumerdes.dz",
                "+213 24 81 64 42"
        );
        dCom.addSpecialite("Licence Sciences Commerciales");
        dCom.addSpecialite("Master Marketing");
        dCom.addSpecialite("Master Commerce International");
        feco.addDepartement(dCom);

        Departement dGestion = new Departement(
                "Département Sciences de Gestion",
                "Formation en management, ressources humaines, comptabilité et audit.",
                "gestion@univ-boumerdes.dz",
                "+213 24 81 64 43"
        );
        dGestion.addSpecialite("Licence Management");
        dGestion.addSpecialite("Master RH");
        dGestion.addSpecialite("Master Comptabilité et Audit");
        feco.addDepartement(dGestion);

        facultes.add(feco);

        // ─── Institut d'Hygiène et Sécurité ────────────────────────────────
        Faculte fihs = new Faculte(
                "Institut d'Hygiène et Sécurité Industrielle",
                "L'Institut forme des spécialistes en sécurité industrielle, hygiène du travail et " +
                        "protection de l'environnement. Il répond aux besoins croissants des industries " +
                        "pétrolières, chimiques et manufacturières en matière de HSE.",
                "ihs@univ-boumerdes.dz",
                "+213 24 81 64 50",
                "Avenue de l'Indépendance, Boumerdès, Algérie",
                36.7488, 3.4755
        );

        Departement dHSE = new Departement(
                "Département HSE",
                "Formation en hygiène, sécurité et environnement industriel (HSE).",
                "hse@univ-boumerdes.dz",
                "+213 24 81 64 51"
        );
        dHSE.addSpecialite("Licence HSE");
        dHSE.addSpecialite("Master Sécurité Industrielle");
        dHSE.addSpecialite("Master Environnement & Développement Durable");
        fihs.addDepartement(dHSE);

        facultes.add(fihs);
    }
}