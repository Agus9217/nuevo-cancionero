package com.justin.songbook.application.advice;

import com.justin.songbook.domain.error.ErrorMessage;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage>notFoundErrorResponse(BadRequestException badRequestException){
        ErrorMessage errorMessage = new ErrorMessage(
                badRequestException.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(errorMessage, errorMessage.getStatus());

    }
}
