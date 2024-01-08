package ch.sp.stundenplaner.api.room;

import ch.sp.stundenplaner.api.dto.JsonParser;
import ch.sp.stundenplaner.api.dto.RoomListDto;
import com.dk.stundenplaner.model.Room;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/room")
public class RoomResource {

    @Inject
    private RoomService service;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveRooms(String rooms) {
        final RoomListDto dto = RoomListDto.fromJson(rooms);
        service.saveRooms(dto);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRooms() {
        final RoomListDto dto = service.readRooms();
        return Response.ok().entity(JsonParser.toJson(dto)).build();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoom(String name) {
        final Room room = service.readRoom(name);
        return Response.ok().entity(JsonParser.toJson(room)).build();
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRoom(String name) {
        service.deleteRoom(name);
        return Response.ok().build();
    }
}
