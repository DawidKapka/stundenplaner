package com.dk.stundenplaner.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "room")
@NamedQuery(name = "findAllRooms", query = "SELECT r FROM RoomEntity r")
@NamedQuery(name = "findRoomByName", query = "SELECT r FROM RoomEntity r WHERE r.name = :name")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RoomEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "roomId")
    private int id;

    @Column(name = "roomName")
    private String name;

    @Column(name = "roomType")
    private String type;

    public RoomEntity() {
    }

    public RoomEntity(String name) {
        this.name = name;
    }
}
