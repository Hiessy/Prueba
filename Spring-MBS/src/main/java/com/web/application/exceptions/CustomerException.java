package com.web.application.exceptions;

public class CustomerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerException() {
	}

	// Constructor that accepts a message
	public CustomerException(String message) {
		super(message);
	}

	public static CustomerException none() {
		// TODO Auto-generated method stub
		return null;
	}

}
