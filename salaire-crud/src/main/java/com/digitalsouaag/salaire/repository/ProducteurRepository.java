package com.digitalsouaag.salaire.repository;

import com.digitalsouaag.salaire.entity.Producteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducteurRepository extends JpaRepository<Producteur, Long> {
}
