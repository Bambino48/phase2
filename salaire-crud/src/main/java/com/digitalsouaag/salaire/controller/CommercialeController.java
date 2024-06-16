package com.digitalsouaag.salaire.controller;

import com.digitalsouaag.salaire.entity.Commerciale;
import com.digitalsouaag.salaire.repository.CommercialeRepository;
import com.digitalsouaag.salaire.service.CommercialeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employer/commerciale")
public class CommercialeController {
    private final CommercialeService commercialeService;
    private final CommercialeRepository commercialeRepository;

    public CommercialeController(CommercialeService commercialeService, CommercialeRepository commercialeRepository) {
        this.commercialeService = commercialeService;
        this.commercialeRepository = commercialeRepository;
    }
    @GetMapping()
    public ResponseEntity<List<Commerciale>> findAllCommerciale() {
        List<Commerciale> list = commercialeService.findAllCommerciale();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<List<Commerciale>> findCommercialeById(@PathVariable Long id) {
        Commerciale findedCommerciale = commercialeService.findCommercialeById(id);
        if (findedCommerciale != null) {
            return new ResponseEntity(findedCommerciale, HttpStatus.OK);
        }
        return new ResponseEntity("Désolé commerciale avec ID " + id + " intriuvable", HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<List<Commerciale>> createCommerciale(@RequestBody Commerciale commerciale) {
        if (commerciale != null) {
            commercialeService.createCommerciale(commerciale);
            return new ResponseEntity(commerciale, HttpStatus.OK);
        }
        return new ResponseEntity("Attention, mauvaise requête", HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/{id}")
    public ResponseEntity<List<Commerciale>> updateCommerciale(@PathVariable Long id, @RequestBody Commerciale commerciale) {
        Optional<Commerciale> findedCommerciale = commercialeRepository.findById(id);
        if (findedCommerciale.isPresent()) {
            commercialeService.updateCommerciale(commerciale);
            return new ResponseEntity(findedCommerciale,HttpStatus.OK);
        }
        return new ResponseEntity("Désolé commerciale avec ID : " + id + " introuvable", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Commerciale>> deleteCommercialeById(@PathVariable Long id) {
        Commerciale findedCommerciale = commercialeService.findCommercialeById(id);
        if (findedCommerciale != null) {
            commercialeService.delete(id);
        }
        if (findedCommerciale == null) {
            return new ResponseEntity("Désolé commerciale avec ID : " + id + " introuvable", HttpStatus.NOT_FOUND);
        }
        return null;
    }
}
