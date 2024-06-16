package com.digitalsouaag.salaire.entity;

import jakarta.persistence.Entity;


import java.time.LocalDateTime;

// Creation de la classe representant heritant de la classe commerciale
@SuppressWarnings("ALL")
@Entity
public class Vendeur extends Commerciale {

    public Vendeur(){}

    private static final double POURCENTAGE_VENDEUR = 0.20;
    private final double BONUS_VENDEUR = 400.0;

    public Vendeur(String nom, String prenom, int age, LocalDateTime dateEntrerService, double chiffreAffaire) {
        super(nom, prenom, age, dateEntrerService, chiffreAffaire);
    }

    @Override
    double calculerSalaire() {
        return ((POURCENTAGE_VENDEUR * getChiffreAffaire()) + BONUS_VENDEUR);
    }

    @Override
    public String afficherNomPrenom() {
        return ("Le vendeur : " + super.afficherNomPrenom());
    }
}
