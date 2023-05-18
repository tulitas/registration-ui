package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "registration-store")
@Path("/registration")
public interface RegistrationClient {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    void register(RegistrationDTO registration);

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<RegistrationDTO> getAllRegistrations();
}
