package com.digitalsouaag.salaire.service;

import com.digitalsouaag.salaire.entity.ProducteurRisque;

import java.util.List;

public interface ProducteurRisqueService {

    List<ProducteurRisque> findAll();
    ProducteurRisque findById(Long id);
    ProducteurRisque create(ProducteurRisque producteurRisque);
    ProducteurRisque update(ProducteurRisque producteurRisque);
    void delete(Long id);
}
