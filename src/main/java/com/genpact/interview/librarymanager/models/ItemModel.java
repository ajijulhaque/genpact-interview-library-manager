package com.genpact.interview.librarymanager.models;

import com.genpact.interview.librarymanager.enums.GENRE;

public class ItemModel {
	private String name;
	private String description;
	private String author;
	private String publishers;
	private GENRE genre;
	private String code;
	private LibraryModel library;
	private BookModel book;
	
	public BookModel getBook() {
		return book;
	}
	public void setBook(BookModel book) {
		this.book = book;
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
	public String getPublishers() {
		return publishers;
	}
	public void setPublishers(String publishers) {
		this.publishers = publishers;
	}
	
	public GENRE getGenre() {
		return genre;
	}
	public void setGenre(GENRE genre) {
		this.genre = genre;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LibraryModel getLibrary() {
		return library;
	}
	public void setLibrary(LibraryModel library) {
		this.library = library;
	}
}
