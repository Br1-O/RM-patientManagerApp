/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.repository;

/**
 *
 * @author Bring Online
 */
import com.bo.patientmanager.model.Patient;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;

public class PatientRepository extends BaseRepository {
        public PatientRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public Patient create(Patient patient) {

        return execute(em -> {
            em.persist(patient);
            return patient;
        });
    }

    public Patient update(Patient patient) {

        return execute(em -> em.merge(patient));
    }

    public void delete(Long id) {

        execute(em -> {

            Patient p = em.find(Patient.class, id);

            if (p != null) {
                em.remove(p);
            }

            return null;
        });
    }

    public Patient findById(Long id) {

        return execute(em ->
            em.find(Patient.class, id)
        );
    }

    public List<Patient> findAll() {

        return execute(em ->
            em.createQuery("from Patient", Patient.class)
              .getResultList()
        );
    }
}
