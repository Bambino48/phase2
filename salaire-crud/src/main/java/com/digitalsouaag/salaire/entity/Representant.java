package com.digitalsouaag.salaire.entity;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

// Creation de la classe representant heritant de la classe commerciale
@Entity
public class Representant extends Commerciale {

    private static final double POURCENTAGE_REPRESENTANT = 0.20;
    private final double BONUS_REPRESENTANT = 800.0;

    public Representant(){}

    public Representant(String nom, String prenom, int age, LocalDateTime dateEntrerService, double chiffreAffaire) {
        super(nom, prenom, age, dateEntrerService, chiffreAffaire);
    }

    @Override
    double calculerSalaire() {
        return ((POURCENTAGE_REPRESENTANT * getChiffreAffaire()) + BONUS_REPRESENTANT);
    }

    @Override
    public String afficherNomPrenom() {
        return ("Le représentant : " + super.afficherNomPrenom());
    }
}
