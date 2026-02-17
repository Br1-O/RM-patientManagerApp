/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.service;

import com.bo.patientmanager.model.Relative;
import com.bo.patientmanager.repository.RelativeRepository;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

/**
 *
 * @author Bring Online
 */
public class RelativeService {
    private final RelativeRepository relativeRepository;

    public RelativeService(EntityManagerFactory emf) {
        this.relativeRepository = new RelativeRepository(emf);
    }

    public Relative create(Relative p) {
        return relativeRepository.create(p);
    }

    public Relative update(Relative p) {
        return relativeRepository.update(p);
    }

    public Relative findById(Long id) {
        return relativeRepository.findById(id);
    }

    public List<Relative> findAll() {
        return relativeRepository.findAll();
    }
}
