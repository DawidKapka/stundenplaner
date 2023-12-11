package com.dk.stundenplaner.dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@RequestScoped
public class TeacherDao {

    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    public void createTeacher(Teacher teacher) {
        em.persist(teacher);
    }

    public Teacher readTeacher(int classId) {
        return em.find(Teacher.class, classId);
    }

    public void updateTeacher(Teacher teacher) {
        em.merge(teacher);
    }

    public void deleteTeacher(Teacher teacher) {
        em.remove(teacher);
    }

    public List<Teacher> readAllTeachers() {
        return em.createNamedQuery("Teacher.findAll", Teacher.class).getResultList();
    }

    public List<Teacher> findTeacher(String firstname, String lastname, String shortcut, String pensum) {
        return em.createNamedQuery("Teacher.findTeacher", Teacher.class)
                .setParameter("firstname", firstname)
                .setParameter("lastname", lastname)
                .setParameter("shortcut", shortcut)
                .setParameter("pensum", pensum).getResultList();
    }
}