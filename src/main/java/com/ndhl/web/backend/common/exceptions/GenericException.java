package com.ndhl.web.backend.common.exceptions;

public class GenericException extends RuntimeException  {
    public GenericException(String message, Throwable e) {
        super(message, e);
    }

    public GenericException(String message) {
        super(message);
    }

    public GenericException(Throwable e) {
        super(e);
    }
}
