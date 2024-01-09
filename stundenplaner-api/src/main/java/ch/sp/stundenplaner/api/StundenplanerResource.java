package ch.sp.stundenplaner.api;

import ch.sp.stundenplaner.api.dto.JsonParser;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("")
public class StundenplanerResource {

    @Inject
    private StundenplanerService service;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateSchedule() {
        return Response.ok().entity(JsonParser.toJson(service.createSchedule())).build();
    }
}
