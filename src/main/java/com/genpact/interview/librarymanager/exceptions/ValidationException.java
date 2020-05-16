package com.genpact.interview.librarymanager.exceptions;

public class ValidationException extends Exception{

	private static final long serialVersionUID = 1L;
	private String msg;
	public ValidationException(String msg) {
		super(msg);
		this.msg = msg;
	}
	public String getMessage() {
		return this.msg;
	}
}
