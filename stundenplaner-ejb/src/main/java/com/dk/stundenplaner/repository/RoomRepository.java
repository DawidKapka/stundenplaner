package com.dk.stundenplaner.repository;

import com.dk.stundenplaner.entity.RoomEntity;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.UserTransaction;

import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class RoomRepository {

    @Resource
    UserTransaction userTransaction;

    @PersistenceContext(unitName = "stundenplaner-jta-pu")
    private EntityManager entityManager;

    public void saveRooms(List<RoomEntity> rooms) {
        try {
            userTransaction.begin();
            rooms.forEach(room -> {
                entityManager.persist(room);
            });
            userTransaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<RoomEntity> readRooms() {
        return entityManager.createNamedQuery("findAllRooms", RoomEntity.class).getResultList();
    }

    public RoomEntity findRoomByName(String name) {
        return entityManager.createNamedQuery("findRoomByName", RoomEntity.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public void deleteRoom(String name) {
        try {
            userTransaction.begin();
            final RoomEntity entity = findRoomByName(name);
            entityManager.remove(entity);
            userTransaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
