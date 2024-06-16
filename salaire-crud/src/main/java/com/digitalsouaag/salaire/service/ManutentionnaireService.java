package com.digitalsouaag.salaire.service;


import com.digitalsouaag.salaire.entity.Manutentionnaire;

import java.util.List;

public interface ManutentionnaireService {

    List<Manutentionnaire> findAllManutentionnaire();
    Manutentionnaire findManutentionnaireById(Long id);
    Manutentionnaire createManutentionnaire(Manutentionnaire manutentionnaire);
    Manutentionnaire updateManutentionnaire(Manutentionnaire manutentionnaire);
    void deleteManutentionnaire(Long id);
}
