/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.repository;

/**
 *
 * @author Bring Online
 */
import com.bo.patientmanager.model.ClinicalHistory;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class ClinicalHistoryRepository extends BaseRepository {

    public ClinicalHistoryRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public ClinicalHistory create(ClinicalHistory entity) {
        return execute(em -> {
            em.persist(entity);
            return entity;
        });
    }

    public ClinicalHistory update(ClinicalHistory entity) {
        return execute(em -> em.merge(entity));
    }

    public void delete(Long id) {
        execute(em -> {
            ClinicalHistory e = em.find(ClinicalHistory.class, id);
            if (e != null) em.remove(e);
            return null;
        });
    }

    public ClinicalHistory findById(Long id) {
        return execute(em -> em.find(ClinicalHistory.class, id));
    }

    public List<ClinicalHistory> findAll() {
        return execute(em ->
            em.createQuery("from ClinicalHistory", ClinicalHistory.class)
              .getResultList()
        );
    }
}

    
