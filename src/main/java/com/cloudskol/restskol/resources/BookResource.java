package com.cloudskol.restskol.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("books")
public class BookResource {

    @Path("hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        return Response.ok().entity("Hello, I am a GET Method").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks() {
        System.out.println("Get all books method called");
        return Response.ok().build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBook(@PathParam("id") String id) {
        System.out.println("Get book method called");
        return Response.ok().build();
    }
}
