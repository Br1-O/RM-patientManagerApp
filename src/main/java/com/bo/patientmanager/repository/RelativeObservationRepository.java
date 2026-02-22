/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.repository;

/**
 *
 * @author Bring Online
 */
import com.bo.patientmanager.model.RelativeObservation;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class RelativeObservationRepository extends BaseRepository {

    public RelativeObservationRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public RelativeObservation create(RelativeObservation entity) {
        return execute(em -> {
            em.persist(entity);
            return entity;
        });
    }

    public RelativeObservation update(RelativeObservation entity) {
        return execute(em -> em.merge(entity));
    }

    public void delete(Long id) {
        execute(em -> {
            RelativeObservation e =
                    em.find(RelativeObservation.class, id);
            if (e != null) em.remove(e);
            return null;
        });
    }

    public RelativeObservation findById(Long id) {
        return execute(em ->
            em.find(RelativeObservation.class, id)
        );
    }

    public List<RelativeObservation> findAll() {
        return execute(em ->
            em.createQuery("from RelativeObservation",
                           RelativeObservation.class)
              .getResultList()
        );
    }
    
    public List<RelativeObservation> findByRelation(Long relationId){
        return execute(em ->em.createQuery("""
            from RelativeObservation ro
            where ro.patientRelativeRelation.id = :id
            order by ro.date desc
        """, RelativeObservation.class)
        .setParameter("id", relationId)
        .getResultList()
        );
    }
}

    

