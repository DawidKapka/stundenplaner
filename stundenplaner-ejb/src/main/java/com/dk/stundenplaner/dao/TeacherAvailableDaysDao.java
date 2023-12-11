package com.dk.stundenplaner.dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@RequestScoped
public class TeacherAvailableDaysDao {

    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    public void createTeacherAvailableDays(TeacherAvailableDays teacherAvailableDays) {
        em.persist(teacherAvailableDays);
    }

    public TeacherAvailableDays readTeacherAvailableDays(int classId) {
        return em.find(TeacherAvailableDays.class, classId);
    }

    public void updateTeacherAvailableDays(TeacherAvailableDays teacherAvailableDays) {
        em.merge(teacherAvailableDays);
    }

    public void deleteTeacherAvailableDays(TeacherAvailableDays teacherAvailableDays) {
        em.remove(teacherAvailableDays);
    }

    public List<TeacherAvailableDays> readAllTeacherAvailableDays() {
        return em.createNamedQuery("TeacherAvailableDays.findAll", TeacherAvailableDays.class).getResultList();
    }

    public List<TeacherAvailableDays> findTeacherAvailableDays(String fk_teacherId, String day) {
        return em.createNamedQuery("TeacherAvailableDays.findTeacherAvailableDays", TeacherAvailableDays.class)
                .setParameter("fk_teacherId", fk_teacherId)
                .setParameter("day", day).getResultList();
    }
}