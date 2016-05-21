package com.cloudskol.restskol.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author tham
 */

@Path("books")
@Produces(MediaType.APPLICATION_JSON)
public interface IBookResource {

    @GET
    public Response getAllBooks();

    @GET
    @Path("{id}")
    public Response getBook(@PathParam("id") String id);
}
