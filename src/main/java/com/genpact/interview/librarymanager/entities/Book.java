package com.genpact.interview.librarymanager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.genpact.interview.librarymanager.enums.BOOK_TYPE;
import com.genpact.interview.librarymanager.enums.GENRE;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long bookId;
	private String name;
	private String description;
	private String author;
	private String publishers;
	private String isbnNo;
	private GENRE genre;
	private String code;
	private BOOK_TYPE type;
	@ManyToOne
	@JoinColumn(name="libraryId", nullable = false)
	private Library library;
	
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BOOK_TYPE getType() {
		return type;
	}
	public void setType(BOOK_TYPE type) {
		this.type = type;
	}
	public String getPublishers() {
		return publishers;
	}
	public void setPublishers(String publishers) {
		this.publishers = publishers;
	}
	public String getIsbnNo() {
		return isbnNo;
	}
	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}
	public GENRE getGenre() {
		return genre;
	}
	public void setGenre(GENRE genre) {
		this.genre = genre;
	}
	
}
