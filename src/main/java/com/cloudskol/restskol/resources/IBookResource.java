package com.cloudskol.restskol.resources;

import com.cloudskol.restskol.model.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author tham
 */

@Path("books")
@Produces(MediaType.APPLICATION_JSON)
public interface IBookResource {

    @GET
    Response getBooks();

    @GET
    @Path("{id}")
    Response getBook(@PathParam("id") String id);

    @POST
    void createBook(Book book);
}
