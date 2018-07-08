package org.rahner.exceptions;

public class TalentAlreadyKnownException extends Exception {

	public TalentAlreadyKnownException() {
		super();
	}

	public TalentAlreadyKnownException(String message) {
		super(message);
	}

	public TalentAlreadyKnownException(String message, Throwable cause) {
		super(message, cause);
	}

	public TalentAlreadyKnownException(Throwable cause) {
		super(cause);
	}
}
