/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.repository;

/**
 *
 * @author Bring Online
 */

import com.bo.patientmanager.model.ClinicalHistoryFile;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class ClinicalHistoryFileRepository extends BaseRepository {

    public ClinicalHistoryFileRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public ClinicalHistoryFile create(ClinicalHistoryFile entity) {
        return execute(em -> {
            em.persist(entity);
            return entity;
        });
    }

    public ClinicalHistoryFile update(ClinicalHistoryFile entity) {
        return execute(em -> em.merge(entity));
    }

    public void delete(Long id) {
        execute(em -> {
            ClinicalHistoryFile e = em.find(ClinicalHistoryFile.class, id);
            if (e != null) em.remove(e);
            return null;
        });
    }

    public ClinicalHistoryFile findById(Long id) {
        return execute(em -> em.find(ClinicalHistoryFile.class, id));
    }

    public List<ClinicalHistoryFile> findAll() {
        return execute(em ->
            em.createQuery("from ClinicalHistoryFile", ClinicalHistoryFile.class)
              .getResultList()
        );
    }
}

    

