package com.digitalsouaag.salaire.repository;

import com.digitalsouaag.salaire.entity.Commerciale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercialeRepository extends JpaRepository<Commerciale, Long> {
}
