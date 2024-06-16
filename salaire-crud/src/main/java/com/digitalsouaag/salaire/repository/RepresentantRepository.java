package com.digitalsouaag.salaire.repository;

import com.digitalsouaag.salaire.entity.Representant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentantRepository extends JpaRepository<Representant, Long> {
}
