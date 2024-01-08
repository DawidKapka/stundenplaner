package ch.sp.stundenplaner.api.mapper;

import com.dk.stundenplaner.entity.RoomEntity;
import com.dk.stundenplaner.model.Room;

public class RoomEntityMapper {

    public static RoomEntity mapToEntity(Room room) {
        final RoomEntity entity = new RoomEntity();
        entity.setName(room.getName());
        return entity;
    }

    public static Room mapToModel(RoomEntity entity) {
        return Room.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
