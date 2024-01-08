package com.dk.stundenplaner.repository;

import com.dk.stundenplaner.entity.ClassEntity;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.UserTransaction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ClassRepository {

    @Resource
    UserTransaction userTransaction;

    @PersistenceContext(unitName = "stundenplaner-jta-pu")
    private EntityManager entityManager;

    public void saveClasses(List<ClassEntity> classes) {
        try {
            userTransaction.begin();
            classes.forEach(entity -> {
                entityManager.persist(entity);
            });
            userTransaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ClassEntity> readClasses() {
        return entityManager.createNamedQuery("findAllClasses", ClassEntity.class).getResultList();
    }

    public ClassEntity readClass(String id) {
        return entityManager.createNamedQuery("findClass", ClassEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public void deleteClass(String id) {
        try {
            userTransaction.begin();
            final ClassEntity entity = readClass(id);
            entityManager.remove(entity);
            userTransaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
