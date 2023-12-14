package com.dk.stundenplaner.dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@RequestScoped
public class ClassModulesDao {

    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    public void createClassModules(ClassModules classModules) {
        em.persist(classModules);
    }

    public ClassModules readClassModules(int classId) {
        return em.find(ClassModules.class, classId);
    }

    public void updateClassModules(ClassModules classModules) {
        em.merge(classModules);
    }

    public void deleteClassModules(ClassModules classModules) {
        em.remove(classModules);
    }

    public List<ClassModules> readAllClassModules() {
        return em.createNamedQuery("ClassModules.findAll", ClassModules.class).getResultList();
    }

    public List<ClassModules> findClassModules(String fk_classId, String fk_moduleId) {
        return em.createNamedQuery("ClassModules.findClassModules", ClassModules.class)
                .setParameter("fk_classId", fk_classId)
                .setParameter("fk_moduleId", fk_classId).getResultList();
    }
}