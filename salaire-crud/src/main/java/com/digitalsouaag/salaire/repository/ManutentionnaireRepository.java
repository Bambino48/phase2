package com.digitalsouaag.salaire.repository;

import com.digitalsouaag.salaire.entity.Manutentionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManutentionnaireRepository extends JpaRepository<Manutentionnaire, Long> {
}
