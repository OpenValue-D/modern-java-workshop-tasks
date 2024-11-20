package de.openvalue.modernjava.webflux.workshop.service;

import de.openvalue.modernjava.webflux.workshop.entity.Book;
import de.openvalue.modernjava.webflux.workshop.entity.Customer;
import de.openvalue.modernjava.webflux.workshop.repository.BookRepository;
import de.openvalue.modernjava.webflux.workshop.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RentService {

    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;

    public RentService(CustomerRepository customerRepository, BookRepository bookRepository) {
        this.customerRepository = customerRepository;
        this.bookRepository = bookRepository;
    }

    public Customer rentBook(Long customerId, Long bookId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not found"));
        book.setCustomer(customerId);
        bookRepository.save(book);
        customer.getBooks().add(book);
        return customerRepository.save(customer);
    }

    public Customer returnBook(Long customerId, Long bookId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not found"));
        book.setCustomer(null);
        bookRepository.save(book);
        customer.getBooks().removeIf(b -> b.getId().equals(bookId));
        return customerRepository.save(customer);
    }
}
