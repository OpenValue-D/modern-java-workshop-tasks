package de.openvalue.modernjava.webflux.workshop.service;

import de.openvalue.modernjava.webflux.workshop.entity.Book;
import de.openvalue.modernjava.webflux.workshop.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
