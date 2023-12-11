package ch.sp.stundenplaner.api.teacher;

import com.dk.stundenplaner.dao.Teacher;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/teacher")
public class TeacherResource {

    @Inject
    private TeacherService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveTeachers(String teachers) {
        //service.saveTeachers(teachers);
        return Response.ok().entity(teachers).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeachers() {
        final List<Teacher> teachers = service.readTeachers();
        return Response.ok().entity(teachers).build();
    }
}
