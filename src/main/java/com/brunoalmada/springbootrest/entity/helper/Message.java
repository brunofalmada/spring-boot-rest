package com.brunoalmada.springbootrest.entity.helper;

/**
 * @author Bruno Faria Almada
 *
 */
public class Message {
	private boolean successful;

	private String message;

	public Message(boolean successful, String message) {
		super();
		this.successful = successful;
		this.message = message;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
