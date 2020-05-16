package com.genpact.interview.librarymanager.models;

import com.genpact.interview.librarymanager.enums.BOOK_TYPE;

public class BookModel{
	private String isbnNo;
	private BOOK_TYPE type;
	
	public String getIsbnNo() {
		return isbnNo;
	}
	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}
	
	public BOOK_TYPE getType() {
		return type;
	}
	public void setType(BOOK_TYPE type) {
		this.type = type;
	}
	
}
