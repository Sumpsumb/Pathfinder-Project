package org.rahner.exceptions;

public class NotEnoughItemsException extends Exception {

	public NotEnoughItemsException() {
		super();
	}

	public NotEnoughItemsException(String message) {
		super(message);
	}

	public NotEnoughItemsException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotEnoughItemsException(Throwable cause) {
		super(cause);
	}
}
