package ch.sp.stundenplaner.api.room;

import ch.sp.stundenplaner.api.dto.RoomListDto;
import com.dk.stundenplaner.mapper.RoomEntityMapper;
import com.dk.stundenplaner.entity.RoomEntity;
import com.dk.stundenplaner.model.Room;
import com.dk.stundenplaner.repository.RoomRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class RoomService {

    @Inject
    private RoomRepository repository;

    public void saveRooms(RoomListDto dto) {
        repository.saveRooms(dto.getRooms().stream()
                .map(RoomEntityMapper::mapToEntity)
                .toList());
    }

    public RoomListDto readRooms() {
        final List<Room> rooms = repository.readRooms().stream()
                .map(RoomEntityMapper::mapToModel)
                .toList();
        return RoomListDto.builder()
                .rooms(rooms)
                .build();
    }

    public Room readRoom(String name) {
        final RoomEntity entity = repository.findRoomByName(name);
        return RoomEntityMapper.mapToModel(entity);
    }

    public void deleteRoom(String name) {
        repository.deleteRoom(name);
    }
}
