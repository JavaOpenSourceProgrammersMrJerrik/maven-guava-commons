package com.mangocity.guava.throwables;

public class GuavaTestException extends Exception {

	private String message;

	public GuavaTestException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "GuavaTestException [message=" + message + "]";
	}
}
