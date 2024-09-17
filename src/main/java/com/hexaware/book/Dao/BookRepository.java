package com.hexaware.book.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.book.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

}
