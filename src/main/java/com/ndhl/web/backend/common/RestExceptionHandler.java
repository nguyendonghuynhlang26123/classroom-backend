package com.ndhl.web.backend.common;

import com.ndhl.web.backend.common.exceptions.ExistingResourceException;
import com.ndhl.web.backend.common.exceptions.GenericException;
import com.ndhl.web.backend.common.response.ErrorResponse;
import com.ndhl.web.backend.common.response.ErrorStatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Centralized place for handling all generic and unexpected exceptions in project.
 */
@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler({Throwable.class, GenericException.class})
    public ResponseEntity<ErrorResponse> handleUnexpectedException(Throwable exception) {
        return errorResponding(ErrorStatusCode.UNEXPECTED_ERROR, exception);
    }

    @ExceptionHandler({ExistingResourceException.class})
    public ResponseEntity<ErrorResponse> handleExistingException(Throwable exception) {
        return errorResponding(ErrorStatusCode.EXISTED_RESOURCES, exception);
    }

    private ResponseEntity<ErrorResponse> errorResponding(ErrorStatusCode statusCode, Throwable e) {
        log.error(e.getClass().getSimpleName() + ": " + e.getMessage(), e);
        ErrorResponse response = new ErrorResponse(e.getMessage(), statusCode);
        return ResponseEntity.status(HttpStatus.valueOf(response.getStatus())).body(response);
    }

}
