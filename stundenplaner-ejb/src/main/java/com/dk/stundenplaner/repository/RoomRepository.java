package com.dk.stundenplaner.repository;

import com.dk.stundenplaner.model.Room;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RoomRepository {

    public void saveRooms(List<Room> rooms) {
        System.out.println(rooms);
    }

    public List<Room> readRooms() {
        return new ArrayList<>();
    }
}
