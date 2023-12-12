package com.dk.stundenplaner.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class SchoolClassDao {

    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    public void createSchoolClass(SchoolClass schoolClass) {
        em.persist(schoolClass);
    }

    public SchoolClass readSchoolClass(int classId) {
        return em.find(SchoolClass.class, classId);
    }

    public void updateSchoolClass(SchoolClass schoolClass) {
        em.merge(schoolClass);
    }

    public void deleteSchoolClass(SchoolClass schoolClass) {
        em.remove(schoolClass);
    }

    public List<SchoolClass> readAllSchoolClass() {
        return em.createNamedQuery("SchoolClass.findAll", SchoolClass.class).getResultList();
    }

    public List<SchoolClass> findSchoolClass(String className) {
        return em.createNamedQuery("SchoolClass.findSchoolClass", SchoolClass.class)
                .setParameter("className", className).getResultList();
    }
}