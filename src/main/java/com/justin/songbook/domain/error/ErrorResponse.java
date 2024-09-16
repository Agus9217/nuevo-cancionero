package com.justin.songbook.domain.error;

public class ErrorResponse extends RuntimeException {
    private int code;

    public ErrorResponse(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
