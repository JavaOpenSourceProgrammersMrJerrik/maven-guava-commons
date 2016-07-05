package com.mangocity.guava.eventbus;

public class CompanyEvent {

	private String message;

	@Override
	public String toString() {
		return "CompanyEvent [message=" + message + "]";
	}

	public CompanyEvent(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
