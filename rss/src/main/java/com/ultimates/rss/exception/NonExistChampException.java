package com.ultimates.rss.exception;

public class NonExistChampException extends RuntimeException {

    public NonExistChampException() {
        super();
    }

    public NonExistChampException(String message) {
        super(message);
    }

    public NonExistChampException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonExistChampException(Throwable cause) {
        super(cause);
    }
}
