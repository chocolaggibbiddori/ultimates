package com.ultimates.rss.exception;

public class IllegalUserException extends IllegalArgumentException {

    public IllegalUserException() {
        super();
    }

    public IllegalUserException(String s) {
        super(s);
    }

    public IllegalUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalUserException(Throwable cause) {
        super(cause);
    }
}
