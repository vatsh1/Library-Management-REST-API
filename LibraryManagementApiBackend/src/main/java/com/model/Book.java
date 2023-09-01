package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_details")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "book_code")
	private int bookCode;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "author")
	private String author;
	@Column(name = "date_added")
	private String dateAdded;

	public Book() {
	}

	public Book(int id, int bookCode, String bookName, String author, String dateAdded) {
		this.id = id;
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.dateAdded = dateAdded;
	}

	public int getId() {
		return id;
	}

	public int getBookCode() {
		return bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthor() {
		return author;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookCode=" + bookCode + ", bookName=" + bookName + ", author=" + author
				+ ", dateAdded=" + dateAdded + "]";
	}

}
