package org.rahner.exceptions;

public class ItemNotInDatabaseException extends Exception {

	public ItemNotInDatabaseException() {
		super();
	}

	public ItemNotInDatabaseException(String message) {
		super(message);
	}

	public ItemNotInDatabaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public ItemNotInDatabaseException(Throwable cause) {
		super(cause);
	}
}
