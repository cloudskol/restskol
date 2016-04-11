package com.cloudskol.restskol.resources;

import com.cloudskol.restskol.data.BookDataStore;
import com.cloudskol.restskol.model.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author tham
 */

@Path("books")
public class VersionedAPI {

    @GET
    @Path("v1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVersion1Books() {
        System.out.println("Get all books from version1 method");
        final List<Book> books = BookDataStore.getInstance().getBooks();
        return Response.ok()
                .entity(books)
                .build();
    }

    @GET
    @Path("v2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVersion2Books() {
        System.out.println("Get all books from version2 method");

        return Response.ok()
                .entity(BookDataStore.getInstance().getBooks())
                .build();
    }
}
