package com.digitalsouaag.salaire.controller;

import com.digitalsouaag.salaire.entity.ManutentionnaireRisque;
import com.digitalsouaag.salaire.repository.ManutentionnaireRisqueRepository;
import com.digitalsouaag.salaire.service.ManutentionnaireRisqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employer/manutentionnairerisque")
public class ManutentionnaireRisqueController {

    private final ManutentionnaireRisqueService manutentionnaireRisqueService;
    private final ManutentionnaireRisqueRepository manutentionnaireRisqueRepository;

    public ManutentionnaireRisqueController(ManutentionnaireRisqueService manutentionnaireRisqueService, ManutentionnaireRisqueRepository manutentionnaireRisqueRepository) {
        this.manutentionnaireRisqueService = manutentionnaireRisqueService;
        this.manutentionnaireRisqueRepository = manutentionnaireRisqueRepository;
    }

    @GetMapping()
    public ResponseEntity<List<ManutentionnaireRisque>> findAllManutentionnaireRisque() {
        List<ManutentionnaireRisque> list = manutentionnaireRisqueService.findAllManutentionnaireRisque();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManutentionnaireRisque> findManutentionnaireRisqueById(@PathVariable("id") Long id) {
        ManutentionnaireRisque findedManutentionnaireRisque = manutentionnaireRisqueService.findManutentionnaireRisqueById(id);
        if (findedManutentionnaireRisque != null) {
            return new ResponseEntity(findedManutentionnaireRisque, HttpStatus.OK);
        }
        return new ResponseEntity("Le manutentionnaire à risque est introuvable ", HttpStatus.NOT_FOUND);

    }
    @PostMapping()
    public ResponseEntity<ManutentionnaireRisque> create(@RequestBody ManutentionnaireRisque manutentionnaireRisque) {
        ManutentionnaireRisque newManutentionnaireRisque = manutentionnaireRisqueService.createManutentionnaireRisque(manutentionnaireRisque);
        return new ResponseEntity(newManutentionnaireRisque, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ManutentionnaireRisque> update(@RequestBody ManutentionnaireRisque manutentionnaireRisque, @PathVariable Long id) {
        Optional<ManutentionnaireRisque> manutentionnaireRisque1 = manutentionnaireRisqueRepository.findById(id);
        if (!manutentionnaireRisque1.isPresent()) {
            return new ResponseEntity("Le manutentionnaire à risque est introuvable ", HttpStatus.NOT_FOUND);
        }
        if (manutentionnaireRisque1.isPresent()) {
            ManutentionnaireRisque manutentionnaireRisque2 = manutentionnaireRisqueService.updateManutentionnaireRisque(manutentionnaireRisque);
            return new ResponseEntity(manutentionnaireRisque2, HttpStatus.OK);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ManutentionnaireRisque> delete(@PathVariable Long id) {
        Optional<ManutentionnaireRisque> oneManutentionnaireRisque = manutentionnaireRisqueRepository.findById(id);
        if (!oneManutentionnaireRisque.isPresent()) {
            return new ResponseEntity("Le manutentionnaire à risque est introuvable ", HttpStatus.NOT_FOUND);
        }
        if (oneManutentionnaireRisque.isPresent()) {
            manutentionnaireRisqueService.deleteManutentionnaireRisque(id);
            return new ResponseEntity("SUCCES, le manutentionnaire à risque est supprimé", HttpStatus.OK);
        }
        return null;

        }

    }
