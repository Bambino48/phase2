package com.digitalsouaag.salaire.controller;

import com.digitalsouaag.salaire.entity.Manutentionnaire;
import com.digitalsouaag.salaire.repository.ManutentionnaireRepository;
import com.digitalsouaag.salaire.service.ManutentionnaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employer/manutentionnaire")
public class ManutentionnaireController {

    private final ManutentionnaireService manutentionnaireService;
    private  final ManutentionnaireRepository manutentionnaireRepository;

    public ManutentionnaireController(ManutentionnaireService manutentionnaireService, ManutentionnaireRepository manutentionnaireRepository) {
        this.manutentionnaireService = manutentionnaireService;
        this.manutentionnaireRepository = manutentionnaireRepository;
    }
    @GetMapping()
    public ResponseEntity<List<Manutentionnaire>> findAllManutentionnaire(){
        List<Manutentionnaire> list = manutentionnaireService.findAllManutentionnaire();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Manutentionnaire> findManutentionnaireById(@PathVariable("id") Long id){
        Manutentionnaire findedManutentionnaire = manutentionnaireService.findManutentionnaireById(id);
        if(findedManutentionnaire != null) {
            return new ResponseEntity<>(findedManutentionnaire, HttpStatus.OK);
        }
        return new ResponseEntity("Le manutentionnaire avec ID : " + id + " est introuvable", HttpStatus.NOT_FOUND);
    }
    @PostMapping()
    public ResponseEntity<Manutentionnaire> createManutentionnaire(@RequestBody Manutentionnaire manutentionnaire){
        Manutentionnaire manutentionnaire1 = manutentionnaireService.createManutentionnaire(manutentionnaire);
        return new ResponseEntity<>(manutentionnaire1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Manutentionnaire> updateManutentionnaire(@RequestBody Manutentionnaire manutentionnaire, @PathVariable("id") Long id){
        Optional<Manutentionnaire> optionalManutentionnaire = manutentionnaireRepository.findById(id);
        if(!optionalManutentionnaire.isPresent()){
            return new ResponseEntity("Le manutentionnaire avec ID : " + id + " est introuvable", HttpStatus.NOT_FOUND);
        }
        if(optionalManutentionnaire.isPresent()){
            Manutentionnaire manutentionnaire1 = manutentionnaireService.updateManutentionnaire(manutentionnaire);
            return new ResponseEntity<>(manutentionnaire1, HttpStatus.OK);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Manutentionnaire> deleteManutentionnaire(@PathVariable("id") Long id){
        Optional<Manutentionnaire> manutentionnaireOptional = manutentionnaireRepository.findById(id);
        if(!manutentionnaireOptional.isPresent()){
            return new ResponseEntity("Le manutentionnaire avec ID : " + id + " est introuvable", HttpStatus.NOT_FOUND);
        }
        if(manutentionnaireOptional.isPresent()){
            manutentionnaireService.deleteManutentionnaire(id);
            return new ResponseEntity("SUCCES, le manutentionnaire est supprimé", HttpStatus.OK);
        }
        return null;
    }
}
