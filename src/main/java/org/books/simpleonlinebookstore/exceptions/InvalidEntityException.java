package org.books.simpleonlinebookstore.exceptions;

public class InvalidEntityException extends RuntimeException {

    public InvalidEntityException() {}

    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntityException(Throwable cause) {
        super(cause);
    }
}

