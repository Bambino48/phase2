package com.digitalsouaag.salaire.service;

import com.digitalsouaag.salaire.entity.Manutentionnaire;
import com.digitalsouaag.salaire.entity.Producteur;

import java.util.List;

public interface ProducteurService {

    List<Producteur> findAllProducteur();
    Producteur findProducteurById(Long id);
    Producteur createProducteur(Producteur producteur);
    Producteur updateProducteur(Producteur producteur);
    void deleteProducteur(Long id);
}
