package ch.sp.stundenplaner.api.module;

import ch.sp.stundenplaner.api.dto.JsonParser;
import ch.sp.stundenplaner.api.dto.ModuleListDto;
import com.dk.stundenplaner.model.SchoolModule;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/module")
public class ModuleResource {

    @Inject
    private ModuleService service;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveModules(String modules) {
        final ModuleListDto dto = ModuleListDto.fromJson(modules);
        service.saveModules(dto);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModules() {
        final ModuleListDto dto = service.readModules();
        return Response.ok().entity(JsonParser.toJson(dto)).build();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModule(String id) {
        final SchoolModule module = service.readModule(id);
        return Response.ok().entity(JsonParser.toJson(module)).build();
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteModule(String id) {
        service.deleteModule(id);
        return Response.ok().build();
    }
}
