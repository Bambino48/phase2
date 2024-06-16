package com.digitalsouaag.salaire.service;

import com.digitalsouaag.salaire.entity.Commerciale;

import java.util.List;

public interface CommercialeService {

    List<Commerciale> findAllCommerciale();
    Commerciale findCommercialeById(Long id);
    Commerciale createCommerciale(Commerciale commerciale);
    Commerciale updateCommerciale(Commerciale commerciale);
    void delete(Long id);
}
