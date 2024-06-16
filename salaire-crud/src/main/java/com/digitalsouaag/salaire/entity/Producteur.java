package com.digitalsouaag.salaire.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// Creation de la classe Producteur heritant de la classe employer
@Entity
@AllArgsConstructor
@Getter
@Setter
public class Producteur extends Employer {

    public final double nombreUnites;
    public final double COEFFICIENT_UNITE = 5;

    public Producteur() {
        nombreUnites = 0;
    }

    public Producteur(String nom, String prenom, int age, LocalDateTime dateEntrerService, double nombreUnites) {
        super(nom, prenom, age, dateEntrerService);
        this.nombreUnites = nombreUnites;
    }

    @Override
    double calculerSalaire() {
        return (nombreUnites * COEFFICIENT_UNITE);
    }

    @Override
    public String afficherNomPrenom() {
        return ("Le producteur : " + super.afficherNomPrenom());
    }
}
