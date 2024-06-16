package com.digitalsouaag.salaire.service.impl;

import com.digitalsouaag.salaire.entity.ManutentionnaireRisque;
import com.digitalsouaag.salaire.repository.ManutentionnaireRisqueRepository;
import com.digitalsouaag.salaire.service.ManutentionnaireRisqueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManutentionnaireRisqueImpl implements ManutentionnaireRisqueService {

    private final ManutentionnaireRisqueRepository manutentionnaireRisqueRepository;

    public ManutentionnaireRisqueImpl(ManutentionnaireRisqueRepository manutentionnaireRisqueRepository) {
        this.manutentionnaireRisqueRepository = manutentionnaireRisqueRepository;
    }

    @Override
    public List<ManutentionnaireRisque> findAllManutentionnaireRisque() {
        return manutentionnaireRisqueRepository.findAll();
    }

    @Override
    public ManutentionnaireRisque findManutentionnaireRisqueById(Long id) {
        Optional<ManutentionnaireRisque> findedManutentionnaireRisque = manutentionnaireRisqueRepository.findById(id);
        if (findedManutentionnaireRisque.isPresent()) {
            return findedManutentionnaireRisque.get();
        }
        return null;
    }

    @Override
    public ManutentionnaireRisque createManutentionnaireRisque(ManutentionnaireRisque manutentionnaireRisque) {
        if (!manutentionnaireRisque.equals("") || manutentionnaireRisque != null) {
            return manutentionnaireRisqueRepository.save(manutentionnaireRisque);
        }
        return null;
    }

    @Override
    public ManutentionnaireRisque updateManutentionnaireRisque(ManutentionnaireRisque manutentionnaireRisque) {
        Optional<ManutentionnaireRisque> findedManutentionnaireRisque = manutentionnaireRisqueRepository.findById(manutentionnaireRisque.getId());
        if (findedManutentionnaireRisque.isPresent()) {
            return manutentionnaireRisqueRepository.saveAndFlush(manutentionnaireRisque);
        }
        return null;
    }

    @Override
    public void deleteManutentionnaireRisque(Long id) {
        Optional<ManutentionnaireRisque> findedManutentionnaireRisque = manutentionnaireRisqueRepository.findById(id);
        if (findedManutentionnaireRisque.isPresent()) {
            manutentionnaireRisqueRepository.deleteById(id);
        }
    }
}
