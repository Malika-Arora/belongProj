package com.belong.customertelephone.exception;

public class CustomInternalServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomInternalServerException() {

	}

	public CustomInternalServerException(String message) {
		super(message);
	}

}
