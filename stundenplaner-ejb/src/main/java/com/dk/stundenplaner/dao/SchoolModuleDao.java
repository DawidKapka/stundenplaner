package com.dk.stundenplaner.dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@RequestScoped
public class SchoolModuleDao {

    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    public void createSchoolModule(SchoolModule schoolModule) {
        em.persist(schoolModule);
    }

    public SchoolModule readSchoolModule(int classId) {
        return em.find(SchoolModule.class, classId);
    }

    public void updateSchoolModule(SchoolModule schoolModule) {
        em.merge(schoolModule);
    }

    public void deleteSchoolModule(SchoolModule schoolModule) {
        em.remove(schoolModule);
    }

    public List<SchoolModule> readAllSchoolModules() {
        return em.createNamedQuery("SchoolModule.findAll", SchoolModule.class).getResultList();
    }

    public List<SchoolModule> findSchoolModule(String moduleName, String duration) {
        return em.createNamedQuery("SchoolModule.findSchoolModule", SchoolModule.class)
                .setParameter("moduleName", moduleName)
                .setParameter("duration", duration).getResultList();
    }
}