package ch.sp.stundenplaner.api.schoolclass;

import ch.sp.stundenplaner.api.dto.ClassListDto;
import ch.sp.stundenplaner.api.dto.JsonParser;
import com.dk.stundenplaner.model.SchoolClass;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/class")
public class ClassResource {

    @Inject
    private ClassService service;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveClasses(String classes) {
        final ClassListDto dto = ClassListDto.fromJson(classes);
        service.saveClasses(dto);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClasses() {
        final ClassListDto dto = service.readClasses();
        return Response.ok().entity(JsonParser.toJson(dto)).build();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClass(String id) {
        final SchoolClass clazz = service.readClass(id);
        return Response.ok().entity(JsonParser.toJson(clazz)).build();
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteClass(String id) {
        //service.deleteClass(id);
        return Response.ok().build();
    }
}
