package com.digitalsouaag.salaire.controller;

import com.digitalsouaag.salaire.entity.Producteur;
import com.digitalsouaag.salaire.repository.ProducteurRepository;
import com.digitalsouaag.salaire.service.ProducteurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employer/producteur")
public class ProducteurController {

    private final ProducteurService producteurService;
    private final ProducteurRepository producteurRepository;

    public ProducteurController(ProducteurService producteurService, ProducteurRepository producteurRepository) {
        this.producteurService = producteurService;
        this.producteurRepository = producteurRepository;
    }

    @GetMapping
    public ResponseEntity<List<Producteur>> findAllProducteur() {
        List<Producteur> list = producteurService.findAllProducteur();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producteur> findProducteurById(@PathVariable("id") Long id) {
        Producteur findedProducteur = producteurService.findProducteurById(id);
        if (findedProducteur != null) {
            return new ResponseEntity<>(findedProducteur, HttpStatus.OK);
        }
        return new ResponseEntity("Producteur avec ID : " + id + " introuvable.", HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Producteur> createProducteur(@RequestBody Producteur producteur) {
        Producteur producteur1 = producteurService.createProducteur(producteur);
        return new ResponseEntity<>(producteur1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producteur> updateProducteur(@RequestBody Producteur producteur, @PathVariable("id") Long id) {
        Optional<Producteur> producteurOptional = producteurRepository.findById(id);
        if (!producteurOptional.isPresent()) {
            return new ResponseEntity("Le producteur est ID : " + id + " est introuvable", HttpStatus.NOT_FOUND);
        }
        if (producteurOptional.isPresent()) {
            Producteur producteur1 = producteurService.updateProducteur(producteur);
            return new ResponseEntity<>(producteur1, HttpStatus.OK);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producteur> deleteProducteur(@PathVariable("id") Long id) {
        Optional<Producteur> producteurOptional = producteurRepository.findById(id);
        if (!producteurOptional.isPresent()) {
            return new ResponseEntity("Le producteur est ID : " + id + " est introuvable", HttpStatus.NOT_FOUND);
        }
        if (producteurOptional.isPresent()) {
            producteurService.deleteProducteur(id);
            return new ResponseEntity("SUCCES, producteur supprimer.", HttpStatus.OK);
        }
        return null;
    }
}
