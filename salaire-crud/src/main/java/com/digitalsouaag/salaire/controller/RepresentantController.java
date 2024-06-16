package com.digitalsouaag.salaire.controller;

import com.digitalsouaag.salaire.entity.Representant;
import com.digitalsouaag.salaire.repository.RepresentantRepository;
import com.digitalsouaag.salaire.service.RepresentantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employer/representant")
public class RepresentantController {


    @Autowired
    private final RepresentantService representantService;
    private final RepresentantRepository representantRepository;

    public RepresentantController(RepresentantService representantService, RepresentantRepository representantRepository) {
        this.representantService = representantService;
        this.representantRepository = representantRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Representant>> findAll() {
        List<Representant> list = representantService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Representant> findById(@PathVariable Long id) {
        Representant finded = representantService.findById(id);
        if (finded != null) {
            return new ResponseEntity(finded, HttpStatus.OK);
        }
        return new ResponseEntity("Désolé representant avec ID " + id + " introuvable", HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Representant> create(@RequestBody Representant representant) {
        if (representant != null) {
            representantService.create(representant);
            return new ResponseEntity<>(representant, HttpStatus.OK);
        }
        return new ResponseEntity<>("Attention, mauvaise requête", HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Representant> update(@PathVariable Long id, @RequestBody Representant representant) {
        Optional<Representant> representantOptional = representantRepository.findById(id);
        if (representantOptional.isPresent()) {
            representantService.update(representant);
            return new ResponseEntity(representantOptional,HttpStatus.OK);
        }
        return new ResponseEntity("Désolé representant avec ID : " + id + " introuvable", HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Representant> delete(@PathVariable Long id) {
        Representant representant = representantService.findById(id);
        if (representant != null) {
            representantService.delete(id);
        }
        if (representant == null) {
            return new ResponseEntity("Désolé representant avec ID : " + id + " introuvable", HttpStatus.NOT_FOUND);
        }
        return null;
    }
}
