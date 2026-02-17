/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.repository;

/**
 *
 * @author Bring Online
 */
import com.bo.patientmanager.model.PatientRelativeRelation;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class PatientRelativeRelationRepository extends BaseRepository {

    public PatientRelativeRelationRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public PatientRelativeRelation create(PatientRelativeRelation entity) {
        return execute(em -> {
            em.persist(entity);
            return entity;
        });
    }

    public PatientRelativeRelation update(PatientRelativeRelation entity) {
        return execute(em -> em.merge(entity));
    }

    public void delete(Long id) {
        execute(em -> {
            PatientRelativeRelation e =
                    em.find(PatientRelativeRelation.class, id);
            if (e != null) em.remove(e);
            return null;
        });
    }

    public PatientRelativeRelation findById(Long id) {
        return execute(em ->
            em.find(PatientRelativeRelation.class, id)
        );
    }

    public List<PatientRelativeRelation> findAll() {
        return execute(em ->
            em.createQuery("from PatientRelativeRelation",
                           PatientRelativeRelation.class)
              .getResultList()
        );
    }
}

    

