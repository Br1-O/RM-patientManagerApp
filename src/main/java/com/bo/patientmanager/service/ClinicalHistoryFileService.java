/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.service;

import com.bo.patientmanager.model.ClinicalHistoryFile;
import com.bo.patientmanager.repository.ClinicalHistoryFileRepository;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

/**
 *
 * @author Bring Online
 */
public class ClinicalHistoryFileService {
    private final ClinicalHistoryFileRepository clinicalHistoryFileRepository;

    public ClinicalHistoryFileService(EntityManagerFactory emf) {
        this.clinicalHistoryFileRepository = new ClinicalHistoryFileRepository(emf);
    }

    public ClinicalHistoryFile create(ClinicalHistoryFile p) {
        return clinicalHistoryFileRepository.create(p);
    }

    public ClinicalHistoryFile update(ClinicalHistoryFile p) {
        return clinicalHistoryFileRepository.update(p);
    }

    public ClinicalHistoryFile findById(Long id) {
        return clinicalHistoryFileRepository.findById(id);
    }

    public List<ClinicalHistoryFile> findAll() {
        return clinicalHistoryFileRepository.findAll();
    }
}
