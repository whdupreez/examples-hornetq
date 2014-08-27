package com.willydupreez.examples.hornetq;

public class MessagingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MessagingException(String message, Throwable cause) {
		super(message, cause);
	}

	public MessagingException(String message) {
		super(message);
	}

}
