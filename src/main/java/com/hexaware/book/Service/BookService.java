package com.hexaware.book.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.book.Dao.BookRepository;
import com.hexaware.book.Exception.BookNotFoundException;
import com.hexaware.book.entity.Book;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;

	public Book addBook(Book library) {
		return bookRepo.save(library);
	}

	public List<Book> getBooks() {
		return (List<Book>) bookRepo.findAll();
	}

	public Book delete(long isbn) {
		Book b = bookRepo.findById(isbn).orElseThrow(()->new BookNotFoundException("Book with ISBN "+ isbn + " not found"));
		if (b != null) {
			bookRepo.delete(b);
		}else {
			return null;
		}
		return b;
	}

	public String updatebook(long isbn, String name) {
		Book b = bookRepo.findById(isbn).orElseThrow(()->new BookNotFoundException("Book with ISBN "+isbn+" not found"));
		if (b == null) {
			return "Book Not Found";
		} else {
			b.setTitle(name);
			bookRepo.save(b);
			return "Name of the book is updated";
		}
	}

	public String findbyISBN(long isbn) {
		Book b = bookRepo.findById(isbn).orElseThrow(()->new BookNotFoundException("Book with ISBN "+isbn+" not found"));
		return b == null ? "Book Not Found" : b.toString();
	}

}
