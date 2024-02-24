package org.agoncal.quarkus.starting;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository repo;

    @GET
    public List<Book> getAllBooks() {
        return repo.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int count(){
        return repo.count();
    }

    @GET
    @Path("/{id}")
    public Optional<Book> getBookWithId(@PathParam("id") int id){
        return repo.getBookWithId(id);
    }
}
