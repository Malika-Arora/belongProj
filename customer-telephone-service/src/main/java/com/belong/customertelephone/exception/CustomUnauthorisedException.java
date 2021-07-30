package com.belong.customertelephone.exception;;

public class CustomUnauthorisedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomUnauthorisedException() {

	}

	public CustomUnauthorisedException(String message) {
		super(message);
	}

}
