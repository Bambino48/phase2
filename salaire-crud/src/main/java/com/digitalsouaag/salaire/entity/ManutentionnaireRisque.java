package com.digitalsouaag.salaire.entity;

import com.digitalsouaag.salaire.utils.PrimeDeRisque;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Creation de la classe manutentionRisque heritant de la classe  Manutention et implementant PrimeDeRisque
@Entity
public class ManutentionnaireRisque extends Manutentionnaire implements PrimeDeRisque {

    public ManutentionnaireRisque() {

    }

    public ManutentionnaireRisque(String nom, String prenom, int age, LocalDateTime dateEntrerService, double nombreHeure) {
        super(nom, prenom, age, dateEntrerService, nombreHeure);
    }

    @Override
    double calculerSalaire() {
        return ((nombreHeure * COEFFICIENT) + PRIME);
    }
}
