package com.dk.stundenplaner.mapper;

import com.dk.stundenplaner.entity.RoomEntity;
import com.dk.stundenplaner.model.Room;
import com.dk.stundenplaner.model.Roomtype;

public class RoomEntityMapper {

    public static RoomEntity mapToEntity(Room room) {
        final RoomEntity entity = new RoomEntity();
        entity.setName(room.getName());
        entity.setType(room.getType().name());
        return entity;
    }

    public static Room mapToModel(RoomEntity entity) {
        return Room.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(Roomtype.valueOf(entity.getType()))
                .build();
    }
}
