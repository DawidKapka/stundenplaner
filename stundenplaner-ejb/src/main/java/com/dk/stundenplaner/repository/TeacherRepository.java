package com.dk.stundenplaner.repository;

import com.dk.stundenplaner.entity.TeacherEntity;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.*;

import java.util.List;

@ApplicationScoped
public class TeacherRepository {

    @Resource
    UserTransaction userTransaction;

    @PersistenceContext(unitName = "stundenplaner-jta-pu")
    private EntityManager entityManager;

    public void saveTeachers(List<TeacherEntity> teacherEntities) {
        try {
            userTransaction.begin();
            teacherEntities.forEach(teacherEntity -> {
                entityManager.persist(teacherEntity);
            });
            userTransaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<TeacherEntity> readTeachers() {
        return entityManager.createNamedQuery("findAllTeachers", TeacherEntity.class).getResultList();
    }

    public TeacherEntity readTeacher(String id) {
        return entityManager.createNamedQuery("findTeacher", TeacherEntity.class)
                .setParameter("id", Integer.valueOf(id))
                .getSingleResult();
    }

    public void deleteTeacher(String id) {
        try {
            userTransaction.begin();
            final TeacherEntity entity = readTeacher(id);
            entityManager.remove(entity);
            userTransaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
