package com.hexaware.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity

public class Book {
	@Id
	@GeneratedValue
	private long isbn;
	
	@NotEmpty(message = "Title is mandatory")
	private String title;
	private String author;
	
	private int publicationYear;
	
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
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
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	@Override
	public String toString() {
		return "Library [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publicationYear="
				+ publicationYear + "]";
	}
	public Book(int isbn, String title, String author, int publicationYear) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
	}
	public Book() {
		super();
	}

	
}
