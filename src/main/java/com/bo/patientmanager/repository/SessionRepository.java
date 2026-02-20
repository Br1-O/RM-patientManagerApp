/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.repository;

/**
 *
 * @author Bring Online
 */
import com.bo.patientmanager.model.Session;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class SessionRepository extends BaseRepository {

    public SessionRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public Session create(Session entity) {
        return execute(em -> {
            em.persist(entity);
            return entity;
        });
    }

    public Session update(Session entity) {
        return execute(em -> em.merge(entity));
    }

    public void delete(Long id) {
        execute(em -> {
            Session e = em.find(Session.class, id);
            if (e != null) em.remove(e);
            return null;
        });
    }

    public Session findById(Long id) {
        return execute(em -> em.find(Session.class, id));
    }

    public List<Session> findAll() {
        return execute(em ->
            em.createQuery("from Session", Session.class)
              .getResultList()
        );
    }
    
    public Long countByPatientId(Long patientId) {

        return execute(em ->
            em.createQuery(
                "select count(s) from Session s where s.patient.id = :id",
                Long.class
            )
            .setParameter("id", patientId)
            .getSingleResult()
        );
    }
    
    public List<Session> findByPatientId(Long patientId) {

        return execute(em ->
            em.createQuery(
                "select s from Session s " +
                "where s.patient.id = :id " +
                "order by s.dayOfWeek, s.from",
                Session.class
            )
            .setParameter("id", patientId)
            .getResultList()
        );
    }
}

    

