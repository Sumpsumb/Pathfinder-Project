package org.rahner.exceptions;

@SuppressWarnings("serial")
public class TalentConditionException extends Exception {

	public TalentConditionException() {
		super();
	}

	public TalentConditionException(String message) {
		super(message);
	}

	public TalentConditionException(String message, Throwable cause) {
		super(message, cause);
	}

	public TalentConditionException(Throwable cause) {
		super(cause);
	}
}
