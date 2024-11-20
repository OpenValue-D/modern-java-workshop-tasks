package de.openvalue.modernjava.webflux.workshop.repository;

import de.openvalue.modernjava.webflux.workshop.entity.Book;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
