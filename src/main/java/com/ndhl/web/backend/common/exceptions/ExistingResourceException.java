package com.ndhl.web.backend.common.exceptions;

public class ExistingResourceException extends GenericException {
    public ExistingResourceException(String message, Throwable e) {
        super(message, e);
    }

    public ExistingResourceException(String message) {
        super(message);
    }

    public ExistingResourceException(Throwable e) {
        super(e);
    }
}
