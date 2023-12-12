package ch.sp.stundenplaner.api.room;

import ch.sp.stundenplaner.api.dto.RoomListDto;
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
        repository.saveRooms(dto.getRooms());
    }

    public RoomListDto readRooms() {
        final List<Room> rooms = repository.readRooms();
        return RoomListDto.builder()
                .rooms(rooms)
                .build();
    }
}
