package com.digitalsouaag.salaire.service;

import com.digitalsouaag.salaire.entity.Vendeur;

import java.util.List;

public interface VendeurService {

    List<Vendeur> findAll();
    Vendeur findById(Long id);
    Vendeur create(Vendeur vendeur);
    Vendeur update(Vendeur vendeur);
    void delete(Long id);
}
