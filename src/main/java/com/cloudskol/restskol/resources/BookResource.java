package com.cloudskol.restskol.resources;

import com.cloudskol.restskol.data.BookDataStore;
import com.cloudskol.restskol.model.Book;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("books")
public class BookResource {

    @Path("info")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response info() {
        return Response.ok().entity("Welcome to our RESTskol library").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
//    @Metered
    public Response getAllBooks() {
        System.out.println("Get all books resource is called");
        final List<Book> books = BookDataStore.getInstance().getBooks();
        return Response.ok()
                .entity(books)
                .build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
//    @Metered
    public Response getBook(@PathParam("id") String id) {
        final Book book = BookDataStore.getInstance().getBook(id);
        return Response.ok()  // (Response code)
                .entity(book) // (response value)
                .build();
    }
}
