package com.controller;

import java.util.List;
import java.util.Optional;

import com.model.Book;
import com.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	// get all book handler
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = this.bookService.getAllBooks();
		return ResponseEntity.of(Optional.of(list));
	}

	// get book by id handler
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = null;
		try {
			book = this.bookService.getBookById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (book == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.of(Optional.of(book));
	}

	// register book handler
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book ee = null;
		try {
			ee = this.bookService.addBook(book);
			return ResponseEntity.of(Optional.of(ee));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// book update handler
	@PostMapping(value = "/books/update")
	public void updatebook(@RequestBody Book book) {
		try {
			this.bookService.updateBook(book, book.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// book delete handler
	@GetMapping(value = "/deletebook/{id}")
	public ResponseEntity<Book> deletebook(@PathVariable("id") int id) {
		Book book = this.bookService.getBookById(id);
		try {
			this.bookService.deleteBook(id);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
