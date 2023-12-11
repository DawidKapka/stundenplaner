package com.dk.stundenplaner.dao;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "room")
@NamedQuery(name = "Room.findAll", query = "SELECT e FROM Room e")
@NamedQuery(name = "Room.findRoom", query = "SELECT e FROM Room e WHERE "
        + "e.roomName = :roomName")
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "roomId")
    private int id;

    @Column(name = "roomName")
    private String roomName;

    public Room() {
    }

    public Room(String roomName) {
        this.roomName = roomName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && Objects.equals(roomName, room.roomName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomName);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                '}';
    }
}