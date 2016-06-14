package com.cloudskol.restskol.resources;

import com.cloudskol.restskol.model.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author tham
 *
 * Interface to define all the endpoints related with {@link PersonResource}
 */

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public interface IPersonResource {

    @GET
    Response all();

    @GET
    @Path("{fName}")
    Response get(@PathParam("fName") String fName);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response create(Person person);

    @PUT
    @Path("{fName}")
    @Consumes(MediaType.APPLICATION_JSON)
    void update(@PathParam("fName") String fName, Person person);

    @DELETE
    @Path("{fName}")
    void delete(@PathParam("fName") String fName);
}
