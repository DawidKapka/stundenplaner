package com.dk.stundenplaner.dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@RequestScoped
public class TeacherModulesDao {

    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    public void createTeacherModules(TeacherModules teacherModules) {
        em.persist(teacherModules);
    }

    public TeacherModules readTeacherModules(int classId) {
        return em.find(TeacherModules.class, classId);
    }

    public void updateTeacherModules(TeacherModules teacherModules) {
        em.merge(teacherModules);
    }

    public void deleteTeacherModules(TeacherModules teacherModules) {
        em.remove(teacherModules);
    }

    public List<TeacherModules> readAllTeacherModules() {
        return em.createNamedQuery("TeacherModules.findAll", TeacherModules.class).getResultList();
    }

    public List<TeacherModules> findTeacherModules(String fk_teacherId, String fk_moduleId) {
        return em.createNamedQuery("TeacherModules.findTeacherModules", TeacherModules.class)
                .setParameter("fk_teacherId", fk_teacherId)
                .setParameter("fk_moduleId", fk_moduleId).getResultList();
    }
}