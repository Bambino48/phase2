package com.digitalsouaag.salaire.entity;

import com.digitalsouaag.salaire.utils.PrimeDeRisque;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

// Creation de la classe ProducteurRisque heritant de producteur et implementant PRIME
@Entity
@Getter
@Setter
public class ProducteurRisque extends Producteur implements PrimeDeRisque {

    public ProducteurRisque(String nom, String prenom, int age, LocalDateTime dateEntrerService, double nombreUnites) {
        super(nom, prenom, age, dateEntrerService, nombreUnites);
    }

    public ProducteurRisque() {

    }

    @Override
    double calculerSalaire() {
        return ((nombreUnites * COEFFICIENT_UNITE) + PRIME);
    }
}
