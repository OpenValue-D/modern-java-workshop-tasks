package de.openvalue.modernjava.webflux.workshop.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;

public class Customer {

	@Id
	private Long id;
	private String name;
	private Set<Book> books;

	public Customer() {
	}

	public Customer(Long id, String name, Set<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
