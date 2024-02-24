package org.agoncal.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class BookRepository {

  @ConfigProperty(name = "books.genre", defaultValue = "Sci-fi")
  String genre;

  public List<Book> getAllBooks() {
    return List.of(
        new Book(1, "Understanding Quarkus", "Antonio", 2020, genre),
        new Book(2, "Practising Quarkus", "Antonio", 2020, genre),
        new Book(3, "Effective Java", "Josh Bloch", 2001, genre),
        new Book(4, "Thinking in Java", "Bruce Eckel", 1998, genre)
    );
  }

  public int countAllBooks(){
    return getAllBooks().size();
  }

  public Optional<Book> getBookWithId(@PathParam("id") int id){
    return getAllBooks().stream().filter(Book -> Book.id == id).findFirst();
  }
}
