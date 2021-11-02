package com.ndhl.web.backend.common.response;

public enum ErrorStatusCode {
    //@formatter:off
    UNAUTHENTICATED(401),
    ACCESS_DENIED(403),
    UNEXPECTED_ERROR(500),
    ENTITY_NOT_FOUND(404),
    CONSTRAINT_VIOLATION(409),
    EXISTED_RESOURCES(409),
    NO_USER_FOUND(404),
    INVALID_DATA(400),
    BAD_INPUT_FORMAT(400),
    BAD_REQUEST(400),
    DATA_NOT_FOUND(404),
    JOB_QUEUE_FULL(503),
    NOT_IMPLEMENTED(501);
    //@formatter:on

    private final int httpStatus;

    ErrorStatusCode() {
        this.httpStatus = 500;
    }

    ErrorStatusCode(final int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}