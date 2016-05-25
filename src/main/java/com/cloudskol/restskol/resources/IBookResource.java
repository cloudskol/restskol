package com.cloudskol.restskol.resources;

import com.cloudskol.restskol.model.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author tham
 *
 * Book REST API contract. This API is to manage Book related resources
 */

@Path("books")
@Produces(MediaType.APPLICATION_JSON)
public interface IBookResource {

    @GET
    Response all();

    @GET
    @Path("{id}")
    Response get(@PathParam("id") String id);

    @POST
    void create(Book book);

    @PUT
    @Path("{id}")
    void update(Book book);

    @DELETE
    @Path("{id}")
    void delete(@PathParam("id") String id);

}
