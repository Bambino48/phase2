package com.digitalsouaag.salaire.entity;

import java.util.ArrayList;

@SuppressWarnings("ALL")
class Personnel {
    final static int MAX_EMPLOYE = 100;
    private int nbreEmployes;
    private final ArrayList<Employer> collectionEmployes;

    public Personnel() {
        collectionEmployes = new ArrayList<Employer>();
        nbreEmployes = 0;
    }

    public void ajouterEmploye(Employer emp) {
        if (collectionEmployes.size() < MAX_EMPLOYE) {
            collectionEmployes.add(emp);
            nbreEmployes++;
        } else {
            System.out.println("Désolé, nombre max d'employés atteint !");
        }

    }

    public void afficherSalaires() {
        // Parcours tout les employés et affiche le salaire de chacun
        for (Employer employe : collectionEmployes) {
            System.out.println(employe.afficherNomPrenom() + " gagne " + employe.calculerSalaire() + " francs.");
        }
    }

    public double salaireMoyen() {
        double somSalaire = 0;
        // Parcours tout les employés et on additionne leurq salaires moyen
        for (Employer employe : collectionEmployes) {
            somSalaire += employe.calculerSalaire();
        }

        return (collectionEmployes.size() > 0 ? somSalaire / collectionEmployes.size() : 0);

    }



}
