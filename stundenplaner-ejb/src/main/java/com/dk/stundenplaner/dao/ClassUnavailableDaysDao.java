package com.dk.stundenplaner.dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@RequestScoped
public class ClassUnavailableDaysDao {

    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    public void createClassUnavailableDays(ClassUnavailableDays classUnavailableDays) {
        em.persist(classUnavailableDays);
    }

    public ClassUnavailableDays readClassUnavailableDays(int classId) {
        return em.find(ClassUnavailableDays.class, classId);
    }

    public void updateClassUnavailableDays(ClassUnavailableDays classUnavailableDays) {
        em.merge(classUnavailableDays);
    }

    public void deleteClassUnavailableDays(ClassUnavailableDays classUnavailableDays) {
        em.remove(classUnavailableDays);
    }

    public List<ClassUnavailableDays> readAllClassUnavailableDays() {
        return em.createNamedQuery("ClassUnavailableDays.findAll", ClassUnavailableDays.class).getResultList();
    }

    public List<ClassUnavailableDays> findClassUnavailableDays(String fk_classId, String day) {
        return em.createNamedQuery("ClassUnavailableDays.findClassUnavailableDays", ClassUnavailableDays.class)
                .setParameter("fk_classId", fk_classId)
                .setParameter("day", fk_classId).getResultList();
    }
}