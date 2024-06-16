package com.digitalsouaag.salaire.service;

import com.digitalsouaag.salaire.entity.Representant;

import java.util.List;

public interface RepresentantService {

    List<Representant> findAll();
    Representant findById(Long id);
    Representant create(Representant representant);
    Representant update(Representant representant);
    void delete(Long id);
}
