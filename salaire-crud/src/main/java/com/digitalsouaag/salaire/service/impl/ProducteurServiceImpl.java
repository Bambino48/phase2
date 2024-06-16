package com.digitalsouaag.salaire.service.impl;

import com.digitalsouaag.salaire.entity.Producteur;
import com.digitalsouaag.salaire.repository.ProducteurRepository;
import com.digitalsouaag.salaire.service.ProducteurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducteurServiceImpl implements ProducteurService {

    private final ProducteurRepository producteurRepository;

    public ProducteurServiceImpl(ProducteurRepository producteurRepository) {
        this.producteurRepository = producteurRepository;
    }

    @Override
    public List<Producteur> findAllProducteur() {
        return producteurRepository.findAll();
    }

    @Override
    public Producteur findProducteurById(Long id) {
        Optional<Producteur> producteurOptional = producteurRepository.findById(id);
        if(producteurOptional.isPresent()){
            return producteurOptional.get();
        }
        return null;
    }

    @Override
    public Producteur createProducteur(Producteur producteur) {
        if(!producteur.equals("") || producteur != null){
            return producteurRepository.save(producteur);
        }
        return null;
    }

    @Override
    public Producteur updateProducteur(Producteur producteur) {
        Optional<Producteur> optionalProducteur = producteurRepository.findById(producteur.getId());
        if(optionalProducteur.isPresent()){
            return producteurRepository.saveAndFlush(producteur);
        }
        return null;
    }

    @Override
    public void deleteProducteur(Long id) {
        Optional<Producteur> producteurOptional = producteurRepository.findById(id);
        if(producteurOptional.isPresent()){
            producteurRepository.deleteById(id);
        }

    }
}
