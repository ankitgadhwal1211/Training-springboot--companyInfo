package com.siddhatech.companyInfo.exception;

import java.time.LocalDateTime;

public class ResponseError {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ResponseError(LocalDateTime timestamp, String message, String details) {
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }

    public ResponseError() {
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
