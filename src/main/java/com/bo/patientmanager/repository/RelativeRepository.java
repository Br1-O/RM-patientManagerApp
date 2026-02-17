/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.repository;

/**
 *
 * @author Bring Online
 */
import com.bo.patientmanager.model.Relative;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class RelativeRepository extends BaseRepository {

    public RelativeRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public Relative create(Relative entity) {
        return execute(em -> {
            em.persist(entity);
            return entity;
        });
    }

    public Relative update(Relative entity) {
        return execute(em -> em.merge(entity));
    }

    public void delete(Long id) {
        execute(em -> {
            Relative e = em.find(Relative.class, id);
            if (e != null) em.remove(e);
            return null;
        });
    }

    public Relative findById(Long id) {
        return execute(em -> em.find(Relative.class, id));
    }

    public List<Relative> findAll() {
        return execute(em ->
            em.createQuery("from Relative", Relative.class)
              .getResultList()
        );
    }
}

    

