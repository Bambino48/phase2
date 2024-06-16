package com.digitalsouaag.salaire.controller;

import com.digitalsouaag.salaire.entity.ProducteurRisque;
import com.digitalsouaag.salaire.repository.ProducteurRisqueRepository;
import com.digitalsouaag.salaire.service.ProducteurRisqueService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employer/producteurrisque")
@Getter
@Setter
public class ProducteurRisqueController {

    private final ProducteurRisqueService  producteurRisqueService;
    private final ProducteurRisqueRepository producteurRisqueRepository;


    public ProducteurRisqueController(ProducteurRisqueService producteurRisqueService, ProducteurRisqueRepository producteurRisqueRepository) {
        this.producteurRisqueService = producteurRisqueService;
        this.producteurRisqueRepository = producteurRisqueRepository;
    }

    @GetMapping()
    public ResponseEntity<List<ProducteurRisque>> findedAll(){
        List<ProducteurRisque> list = producteurRisqueService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProducteurRisque> findedById(@PathVariable Long id){
        ProducteurRisque producteurRisque = producteurRisqueService.findById(id);
        if(producteurRisque != null){
            return new ResponseEntity<>(producteurRisque, HttpStatus.OK);
        }
        return new ResponseEntity("Désolé producteur à risque avec ID : " + id + " introuvable.", HttpStatus.OK );
    }

    @PostMapping()
    public ResponseEntity<ProducteurRisque> create(@RequestBody ProducteurRisque producteurRisque){
        if(producteurRisque != null){
            producteurRisqueService.create(producteurRisque);
            return new ResponseEntity<>(producteurRisque, HttpStatus.OK);
        }
        return new ResponseEntity("Attention, mauvaise requette.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProducteurRisque> update(@RequestBody ProducteurRisque producteurRisque, @PathVariable Long id){
        Optional<ProducteurRisque> producteurRisqueOptional = producteurRisqueRepository.findById(id);
        if(producteurRisqueOptional != null){
            producteurRisqueService.update(producteurRisque);
        }
        return new ResponseEntity("Désolé producteur à risque avec ID : " + id + " introuvable.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProducteurRisque> delete(@PathVariable Long id){
       Optional<ProducteurRisque> producteurRisqueOptional = producteurRisqueRepository.findById(id);
       if(producteurRisqueOptional.isPresent()){
           producteurRisqueService.delete(id);
        }
       if(!producteurRisqueOptional.isPresent()){
           return new ResponseEntity("Désolé le producteur à risque avec ID : " + id + " introuvable.", HttpStatus.NOT_FOUND);
       }
        return null;
    }
}
