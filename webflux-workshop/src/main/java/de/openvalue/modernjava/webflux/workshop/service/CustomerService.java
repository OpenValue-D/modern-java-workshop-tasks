package de.openvalue.modernjava.webflux.workshop.service;

import de.openvalue.modernjava.webflux.workshop.entity.Customer;
import de.openvalue.modernjava.webflux.workshop.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer not found"));
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
