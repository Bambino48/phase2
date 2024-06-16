package com.digitalsouaag.salaire.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// Creation de la classe Commerciale heritant de la classe employer


@AllArgsConstructor
@Entity
public class Commerciale extends Employer {

    // Declaration de la variable
    private double chiffreAffaire;

    public Commerciale() {

    }

    public Commerciale(String nom, String prenom, int age, LocalDateTime dateEntrerService, double chiffreAffaire) {
        super(nom, prenom, age, dateEntrerService);
        this.chiffreAffaire = chiffreAffaire;
    }

    @Override
    double calculerSalaire() {

        return 0;
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }
}
