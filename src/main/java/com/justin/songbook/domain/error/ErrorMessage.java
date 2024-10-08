package com.justin.songbook.domain.error;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    String message;
    HttpStatus status;


    public ErrorMessage() {
    }

    public ErrorMessage(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
