package com.digitalsouaag.salaire.service;

import com.digitalsouaag.salaire.entity.ManutentionnaireRisque;

import java.util.List;

public interface ManutentionnaireRisqueService  {

    List<ManutentionnaireRisque> findAllManutentionnaireRisque();
    ManutentionnaireRisque findManutentionnaireRisqueById(Long id);
    ManutentionnaireRisque createManutentionnaireRisque(ManutentionnaireRisque manutentionnaireRisque);
    ManutentionnaireRisque updateManutentionnaireRisque(ManutentionnaireRisque manutentionnaireRisque);
    void deleteManutentionnaireRisque(Long id);
}
