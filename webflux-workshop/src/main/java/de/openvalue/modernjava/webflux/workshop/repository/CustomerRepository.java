package de.openvalue.modernjava.webflux.workshop.repository;


import de.openvalue.modernjava.webflux.workshop.entity.Customer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	@Query("SELECT * FROM customer WHERE name = :name")
	Customer findByName(@Param("name") String name);

	List<Customer> findAll();

	Customer findById(long id);
}
