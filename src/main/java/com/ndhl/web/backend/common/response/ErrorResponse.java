package com.ndhl.web.backend.common.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.UUID;

@Data
public class ErrorResponse {
    @JsonProperty
    private final Date timestamp;
    @JsonProperty
    private final String path;
    @JsonProperty
    private String message;
    @JsonProperty
    private int status;
    @JsonProperty
    private String error;
//    @JsonProperty
//    private String correlationId;

    public ErrorResponse(final String message, final ErrorStatusCode error) {
        this.status = error.getHttpStatus();
        this.error = error.name();
        this.message = message;
        this.timestamp = new Date();
        final ServletRequestAttributes sra = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        if (sra != null) {
            this.path = sra.getRequest().getRequestURI();
        } else {
            this.path = "unknown";
        }
//        this.correlationId = MDC.get(MDCContext.CORRELATION_ID);
    }

    public ErrorResponse(final int status, final String message, final ErrorStatusCode error) {
        this.status = status;
        this.error = error.name();
        this.message = message;
        this.timestamp = new Date();
        final ServletRequestAttributes sra = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        if (sra != null) {
            this.path = sra.getRequest().getRequestURI();
        } else {
            this.path = "unknown";
        }
//        this.correlationId = MDC.get(MDCContext.CORRELATION_ID);
    }
    @Override
    public String toString() {
        return String.format("RestError[%s] at %tc on %s [%d/%s]: %s",
                UUID.randomUUID(), this.timestamp, this.path, this.status,
                this.error, this.message);
    }

}
