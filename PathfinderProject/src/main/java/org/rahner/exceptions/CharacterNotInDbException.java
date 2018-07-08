package org.rahner.exceptions;

public class CharacterNotInDbException extends Exception {

	public CharacterNotInDbException() {
		super();
	}

	public CharacterNotInDbException(String message) {
		super(message);
	}

	public CharacterNotInDbException(String message, Throwable cause) {
		super(message, cause);
	}

	public CharacterNotInDbException(Throwable cause) {
		super(cause);
	}
}
