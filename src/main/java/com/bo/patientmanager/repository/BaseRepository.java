/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.repository;

/**
 *
 * @author Bring Online
 */
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.function.Function;
import persistence.JPAUtil;

public abstract class BaseRepository {

    protected EntityManagerFactory emf;

    protected BaseRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    protected <T> T execute(Function<EntityManager, T> action) {

        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();

            T result = action.apply(em);

            em.getTransaction().commit();

            return result;

        } catch (RuntimeException ex) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw ex;

        } finally {
            em.close();
        }
    }
}