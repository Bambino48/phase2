package com.digitalsouaag.salaire.service.impl;

import com.digitalsouaag.salaire.entity.ProducteurRisque;
import com.digitalsouaag.salaire.repository.ProducteurRisqueRepository;
import com.digitalsouaag.salaire.service.ProducteurRisqueService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
public class ProducteurRisqueServiceImpl implements ProducteurRisqueService {

    private final ProducteurRisqueRepository producteurRisqueRepository;

    public ProducteurRisqueServiceImpl(ProducteurRisqueRepository producteurRisqueRepository) {
        this.producteurRisqueRepository = producteurRisqueRepository;
    }

    @Override
    public List<ProducteurRisque> findAll() {
        return producteurRisqueRepository.findAll();
    }

    @Override
    public ProducteurRisque findById(Long id) {
        Optional<ProducteurRisque> finded = producteurRisqueRepository.findById(id);
        if(finded.isPresent()){
            return finded.get();
        }
        return null;
    }

    @Override
    public ProducteurRisque create(ProducteurRisque producteurRisque) {
        if(!producteurRisque.equals("") || producteurRisque != null){
            ProducteurRisque producteurRisque1 = new ProducteurRisque();
            producteurRisque1.setNom(producteurRisque.getNom());
            producteurRisque1.setPrenom(producteurRisque.getPrenom());
            producteurRisque1.setAge(producteurRisque.getAge());
            producteurRisque1.setDateEntrerService(producteurRisque.getDateEntrerService());
            return producteurRisqueRepository.save(producteurRisque1);

        }
        return null;
    }

    @Override
    public ProducteurRisque update(ProducteurRisque producteurRisque) {
        Optional<ProducteurRisque> producteurRisqueOptional = producteurRisqueRepository.findById(producteurRisque.getId());
        if(producteurRisqueOptional.isPresent()){
            return producteurRisqueRepository.saveAndFlush(producteurRisque);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<ProducteurRisque> producteurRisqueOptional =producteurRisqueRepository.findById(id);
        if(producteurRisqueOptional.isPresent()){
            producteurRisqueRepository.deleteById(id);
        }

    }
}
