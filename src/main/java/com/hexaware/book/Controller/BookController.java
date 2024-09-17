package com.hexaware.book.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.book.Service.BookService;
import com.hexaware.book.entity.Book;

@RestController
@RequestMapping("/api/admin") 
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
    	return bookService.getBooks();
    }
    
    @GetMapping("/findByISBN/{isbn}")
    public String findByISBN(@PathVariable("isbn") long isbn) {
    	return bookService.findbyISBN(isbn);
    }
    
    @PostMapping("/addNewBook")
    public Book addNewBook(@RequestBody Book library) {
        return bookService.addBook(library);
    }


    @PutMapping("/updateBook/{isbn}/{name}")
    public String updateBook(@PathVariable("isbn") long isbn, @PathVariable("name") String name) {
        return bookService.updatebook(isbn, name);
    }
    
    @DeleteMapping("/deleteBook/{isbn}")
    public Book deleteBook(@PathVariable("isbn") long isbn) {
    	return bookService.delete(isbn);
    }


}
