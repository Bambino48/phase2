package com.digitalsouaag.salaire.service.impl;

import com.digitalsouaag.salaire.entity.Manutentionnaire;
import com.digitalsouaag.salaire.repository.ManutentionnaireRepository;
import com.digitalsouaag.salaire.service.ManutentionnaireService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManutentionnaireServiceImpl implements ManutentionnaireService {

    private final ManutentionnaireRepository manutentionnaireRepository;

    public ManutentionnaireServiceImpl(ManutentionnaireRepository manutentionnaireRepository) {
        this.manutentionnaireRepository = manutentionnaireRepository;
    }

    @Override
    public List<Manutentionnaire> findAllManutentionnaire() {
        return manutentionnaireRepository.findAll();
    }

    @Override
    public Manutentionnaire findManutentionnaireById(Long id) {
        Optional<Manutentionnaire> findedManutentionnaire = manutentionnaireRepository.findById(id);
        return findedManutentionnaire.orElse(null);
    }

    @Override
    public Manutentionnaire createManutentionnaire(Manutentionnaire manutentionnaire) {
        if (!manutentionnaire.equals("") || manutentionnaire != null) {
            return manutentionnaireRepository.save(manutentionnaire);
        }
        return null;
    }

    @Override
    public Manutentionnaire updateManutentionnaire(Manutentionnaire manutentionnaire) {
        Optional<Manutentionnaire> findedManutentionnaire = manutentionnaireRepository.findById(manutentionnaire.getId());
        if(findedManutentionnaire.isPresent()) {
            return manutentionnaireRepository.saveAndFlush(manutentionnaire);
        }
        return null;
    }

    @Override
    public void deleteManutentionnaire(Long id) {
        Optional<Manutentionnaire> findedManutentionnaire = manutentionnaireRepository.findById(id);
        if(findedManutentionnaire.isPresent()) {
            manutentionnaireRepository.deleteById(id);
        }

    }
}
