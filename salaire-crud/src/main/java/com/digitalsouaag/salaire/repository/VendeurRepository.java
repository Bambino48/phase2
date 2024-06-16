package com.digitalsouaag.salaire.repository;

import com.digitalsouaag.salaire.entity.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendeurRepository extends JpaRepository<Vendeur, Long> {
}
