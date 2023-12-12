package com.dk.stundenplaner.dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@RequestScoped
public class RoomDao {

    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    public void createRoom(Room room) {
        em.persist(room);
    }

    public Room readRoom(int classId) {
        return em.find(Room.class, classId);
    }

    public void updateRoom(Room room) {
        em.merge(room);
    }

    public void deleteRoom(Room room) {
        em.remove(room);
    }

    public List<Room> readAllRooms() {
        return em.createNamedQuery("Room.findAll", Room.class).getResultList();
    }

    public List<Room> findRoom(String roomName) {
        return em.createNamedQuery("Room.findRoom", Room.class)
                .setParameter("roomName", roomName).getResultList();
    }
}