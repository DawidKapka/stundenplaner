package com.dk.stundenplaner.repository;

import com.dk.stundenplaner.entity.ModuleEntity;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.UserTransaction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ModuleRepository {

    @Resource
    UserTransaction userTransaction;

    @PersistenceContext(unitName = "stundenplaner-jta-pu")
    private EntityManager entityManager;

    public void saveModules(List<ModuleEntity> modules) {
        try {
            userTransaction.begin();
            modules.forEach(entity -> {
                entityManager.persist(entity);
            });
            userTransaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ModuleEntity> readModules() {
        return entityManager.createNamedQuery("findAllModules", ModuleEntity.class).getResultList();
    }

    public ModuleEntity findModuleByShortcut(String shortcut) {
        return entityManager.createNamedQuery("findModuleByShortcut", ModuleEntity.class)
                .setParameter("shortcut", shortcut)
                .getSingleResult();
    }

    public void deleteModule(String shortcut) {
        try {
            userTransaction.begin();
            final ModuleEntity module = findModuleByShortcut(shortcut);
            entityManager.remove(module);
            userTransaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
