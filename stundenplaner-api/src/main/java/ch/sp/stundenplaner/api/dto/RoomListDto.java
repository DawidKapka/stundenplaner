package ch.sp.stundenplaner.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.dk.stundenplaner.model.Room;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomListDto extends AbstractDto {
    @Builder.Default
    final List<Room> rooms = new ArrayList<>();

    public static RoomListDto fromJson(String json) {
        return fromJson(json, RoomListDto.class);
    }
}
