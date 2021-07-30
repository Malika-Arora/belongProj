package com.belong.customertelephone.exception;

public class TooManyRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TooManyRequestException() {
    }

    public TooManyRequestException(String message) {
        super(message);
    }

    public TooManyRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
