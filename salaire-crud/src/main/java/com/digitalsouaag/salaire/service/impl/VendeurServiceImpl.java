package com.digitalsouaag.salaire.service.impl;

import com.digitalsouaag.salaire.entity.Vendeur;
import com.digitalsouaag.salaire.repository.VendeurRepository;
import com.digitalsouaag.salaire.service.VendeurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendeurServiceImpl implements VendeurService {

    private final VendeurRepository vendeurRepository;

    public VendeurServiceImpl(VendeurRepository vendeurRepository) {
        this.vendeurRepository = vendeurRepository;
    }

    @Override
    public List<Vendeur> findAll() {
        return vendeurRepository.findAll();
    }

    @Override
    public Vendeur findById(Long id) {
        Optional<Vendeur> vendeurOptional = vendeurRepository.findById(id);
        if(vendeurOptional.isPresent()){
            return vendeurOptional.get();
        }
        return null;
    }

    @Override
    public Vendeur create(Vendeur vendeur) {
        if (!vendeur.equals("") || vendeur != null) {
            return vendeurRepository.save(vendeur);
        }
        return null;
    }

    @Override
    public Vendeur update(Vendeur vendeur) {
        Optional<Vendeur> optionalVendeur = vendeurRepository.findById(vendeur.getId());
        if(optionalVendeur.isPresent()){
            return vendeurRepository.saveAndFlush(vendeur);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Vendeur> vendeur = vendeurRepository.findById(id);
        if(vendeur.isPresent()){
            vendeurRepository.deleteById(id);
        }

    }
}
