package com.hexaware.book.Repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.book.Dao.BookRepository;
import com.hexaware.book.entity.Book;

@SpringBootTest
public class BookMethodTest {
	
	    @Autowired
	    private BookRepository bookRepository;

	   
	    @Test
	    void saveBookTest() {
	        Book book = new Book(3, "Ikigai", "Fancesc Miralles", 2016);
	        bookRepository.save(book);
	    }
	    
	    @Test
	    void findByIsbnTest() {
	        Book book = bookRepository.findById((long) 2).orElse(null);
	        System.out.println( book);
	    }

	    
	    @Test
	    void findAllBooksTest() {
	        List<Book> books = (List<Book>) bookRepository.findAll();
	        for (Book book : books) {
	            System.out.println(book);
	        }
	    }

	    
	    @Test
	    void updateBookTitleTest() {
	        Book book = bookRepository.findById((long) 2).orElse(null);
	        if (book != null) {
	            book.setTitle("It ends with us");
	            bookRepository.save(book);
	            System.out.println(book);
	        } else {
	            System.out.println("Book not found.");
	        }
	    }
	    
	    @Test
	    void deleteBookTest() {
	    	Book book= bookRepository.findById((long) 102).orElse(null);
	    	if(book!=null) {
	    		bookRepository.delete(book);
	    		System.out.println("Deleted book: "+ book);
	    	}else {
	    		System.out.println("Book not found");
	    	}
	    }
}
