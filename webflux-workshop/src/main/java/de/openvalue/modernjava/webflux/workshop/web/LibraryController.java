package de.openvalue.modernjava.webflux.workshop.web;

import de.openvalue.modernjava.webflux.workshop.entity.Book;
import de.openvalue.modernjava.webflux.workshop.entity.Customer;
import de.openvalue.modernjava.webflux.workshop.service.BookService;
import de.openvalue.modernjava.webflux.workshop.service.CustomerService;
import de.openvalue.modernjava.webflux.workshop.service.RentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LibraryController {

    private final CustomerService customerService;
    private final BookService bookService;
    private final RentService rentService;

    public LibraryController(CustomerService customerService, BookService bookService, RentService rentService) {
        this.customerService = customerService;
        this.bookService = bookService;
        this.rentService = rentService;
    }


    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping("/customer/{customerId}/rent/{bookId}")
    public Customer rentBook(@PathVariable("customerId") Long customerId, @PathVariable("bookId") Long bookId) {
        return rentService.rentBook(customerId, bookId);
    }

    @GetMapping("/customer/{customerId}/return/{bookId}")
    public Customer returnBook(@PathVariable("customerId") Long customerId, @PathVariable("bookId") Long bookId) {
        return rentService.returnBook(customerId, bookId);
    }

}