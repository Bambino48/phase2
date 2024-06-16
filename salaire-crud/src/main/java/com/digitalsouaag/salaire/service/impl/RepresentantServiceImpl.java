package com.digitalsouaag.salaire.service.impl;

import com.digitalsouaag.salaire.entity.Representant;
import com.digitalsouaag.salaire.repository.RepresentantRepository;
import com.digitalsouaag.salaire.service.RepresentantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepresentantServiceImpl implements RepresentantService {

    private final RepresentantRepository representantRepository;

    public RepresentantServiceImpl(RepresentantRepository representantRepository) {
        this.representantRepository = representantRepository;
    }

    @Override
    public List<Representant> findAll() {
        return representantRepository.findAll();
    }

    @Override
    public Representant findById(Long id) {
        Optional<Representant> representantOptional = representantRepository.findById(id);
        if(representantOptional.isPresent()){
            return representantOptional.get();
        }
        return null;
    }

    @Override
    public Representant create(Representant representant) {
        if(!representant.equals("") || representant != null){
            return representantRepository.save(representant);
        }
        return null;
    }

    @Override
    public Representant update(Representant representant) {
        Optional<Representant> optionalRepresentant = representantRepository.findById(representant.getId());
               if(optionalRepresentant.isPresent()){
                   return representantRepository.saveAndFlush(representant);
               }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Representant> representant = representantRepository.findById(id);
        if(representant.isPresent()){
            representantRepository.deleteById(id);
        }

    }
}
