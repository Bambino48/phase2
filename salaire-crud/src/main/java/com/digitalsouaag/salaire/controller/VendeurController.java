package com.digitalsouaag.salaire.controller;

import com.digitalsouaag.salaire.entity.Commerciale;
import com.digitalsouaag.salaire.entity.Vendeur;
import com.digitalsouaag.salaire.repository.VendeurRepository;
import com.digitalsouaag.salaire.service.VendeurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employer/vendeur")
public class VendeurController {

    private final VendeurService vendeurService;
    private final VendeurRepository vendeurRepository;

    public VendeurController(VendeurService vendeurService, VendeurRepository vendeurRepository) {
        this.vendeurService = vendeurService;
        this.vendeurRepository = vendeurRepository;
    }
    @GetMapping()
    public ResponseEntity<List<Vendeur>> findAll() {
        List<Vendeur> list = vendeurService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Vendeur> findById(@PathVariable Long id) {
        Vendeur finded = vendeurService.findById(id);
        if (finded != null) {
            return new ResponseEntity(finded, HttpStatus.OK);
        }
        return new ResponseEntity("Désolé vendeur avec ID " + id + " intriuvable", HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Vendeur> create(@RequestBody Vendeur vendeur) {
        if (vendeur != null) {
           vendeurService.create(vendeur);
            return new ResponseEntity(vendeur, HttpStatus.OK);
        }
        return new ResponseEntity("Attention, mauvaise requête", HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Vendeur> update(@PathVariable Long id, @RequestBody Vendeur vendeur) {
        Optional<Vendeur> vendeurOptional = vendeurRepository.findById(id);
        if (vendeurOptional.isPresent()) {
            vendeurService.update(vendeur);
            return new ResponseEntity(vendeurOptional,HttpStatus.OK);
        }
        return new ResponseEntity("Désolé vendeur avec ID : " + id + " introuvable", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Vendeur> delete(@PathVariable Long id) {
        Vendeur vendeur = vendeurService.findById(id);
        if (vendeur != null) {
            vendeurService.delete(id);
        }
        if (vendeur == null) {
            return new ResponseEntity("Désolé vendeur avec ID : " + id + " introuvable", HttpStatus.NOT_FOUND);
        }
        return null;
    }
}
