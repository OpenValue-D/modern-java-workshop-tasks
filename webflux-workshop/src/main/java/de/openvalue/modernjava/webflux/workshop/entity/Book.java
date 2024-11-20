package de.openvalue.modernjava.webflux.workshop.entity;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Book {

	@Id
	private Long id;
	private String title;
	private String author;
	private Long customer;

	public Book() {
	}

	public Book(Long id, String title, String author, Long customer) {
		super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.customer = customer;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getCustomer() {
		return customer;
	}

	public void setCustomer(Long customer) {
		this.customer = customer;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		Book book = (Book) object;
		return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(customer, book.customer);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, author, customer);
	}
}
