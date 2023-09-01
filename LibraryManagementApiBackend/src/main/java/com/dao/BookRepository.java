package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id);
}
