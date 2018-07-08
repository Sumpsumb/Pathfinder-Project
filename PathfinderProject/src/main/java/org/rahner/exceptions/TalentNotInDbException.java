package org.rahner.exceptions;

public class TalentNotInDbException extends Exception {

	public TalentNotInDbException() {
		super();
	}

	public TalentNotInDbException(String message) {
		super(message);
	}

	public TalentNotInDbException(String message, Throwable cause) {
		super(message, cause);
	}

	public TalentNotInDbException(Throwable cause) {
		super(cause);
	}
}
