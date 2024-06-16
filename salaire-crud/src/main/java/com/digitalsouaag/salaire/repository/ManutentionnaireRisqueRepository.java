package com.digitalsouaag.salaire.repository;

import com.digitalsouaag.salaire.entity.ManutentionnaireRisque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManutentionnaireRisqueRepository extends JpaRepository<ManutentionnaireRisque, Long> {
}
