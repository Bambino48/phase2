package com.digitalsouaag.salaire.service.impl;

import com.digitalsouaag.salaire.entity.Commerciale;
import com.digitalsouaag.salaire.repository.CommercialeRepository;
import com.digitalsouaag.salaire.service.CommercialeService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter
@Getter
public class CommercialeServiceImpl implements CommercialeService {


    private final CommercialeRepository commercialeRepository;

    public CommercialeServiceImpl(CommercialeRepository commercialeRepository) {
        this.commercialeRepository = commercialeRepository;
    }

    @Override
    public List<Commerciale> findAllCommerciale() {
        return commercialeRepository.findAll();
    }

    @Override
    public Commerciale findCommercialeById(Long id) {
        Optional<Commerciale> findedCommerciale = commercialeRepository.findById(id);
        if (findedCommerciale.isPresent()) {
            return findedCommerciale.get();
        }
        return null;
    }

    @Override
    public Commerciale createCommerciale(Commerciale commerciale) {
        if (!commerciale.equals("") || commerciale != null) {
            Commerciale newCommerciale = new Commerciale();
            newCommerciale.setNom(commerciale.getNom());
            newCommerciale.setPrenom(commerciale.getPrenom());
            newCommerciale.setAge(commerciale.getAge());
            newCommerciale.setDateEntrerService(commerciale.getDateEntrerService());
            newCommerciale.setChiffreAffaire(commerciale.getChiffreAffaire());
        return commercialeRepository.save(newCommerciale);
        }
        return null;
    }

    @Override
    public Commerciale updateCommerciale(Commerciale commerciale) {
        Optional<Commerciale> findedCommerciale = commercialeRepository.findById(commerciale.getId());
        if (findedCommerciale.isPresent()) {
            return commercialeRepository.saveAndFlush(commerciale);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Commerciale> findedCommerciale = commercialeRepository.findById(id);
        if (findedCommerciale.isPresent()) {
            commercialeRepository.deleteById(id);
        }

    }
}
