package com.justin.songbook.domain.error;

public class NotFoundResponse extends Exception {
    public NotFoundResponse(String message) {
        super(message);
    }
}
