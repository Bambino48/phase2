package com.digitalsouaag.salaire.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Creation de la classe Manutentionnaire heritant de la classe Employer
@Entity
public class Manutentionnaire extends Employer {
    public  double nombreHeure;
    public final double COEFFICIENT = 65;

    public Manutentionnaire() {

    }

    public Manutentionnaire(String nom, String prenom, int age, LocalDateTime dateEntrerService, double nombreHeure) {
        super(nom, prenom, age, dateEntrerService);
        this.nombreHeure = nombreHeure;
    }

    @Override
    double calculerSalaire() {
        return (nombreHeure * COEFFICIENT);
    }

    @Override
    public String afficherNomPrenom() {
        return ("le manutentionnaire " + super.afficherNomPrenom());
    }
}
