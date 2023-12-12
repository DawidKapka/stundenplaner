package ch.sp.stundenplaner.api.teacher;

import ch.sp.stundenplaner.api.dto.JsonParser;
import ch.sp.stundenplaner.api.dto.TeacherListDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/teacher")
public class TeacherResource {

    @Inject
    private TeacherService service;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveTeachers(String teachers) {
        final TeacherListDto dto = TeacherListDto.fromJson(teachers);
        service.saveTeachers(dto);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeachers() {
        final TeacherListDto dto = service.readTeachers();
        return Response.ok().entity(JsonParser.toJson(dto)).build();
    }
}
