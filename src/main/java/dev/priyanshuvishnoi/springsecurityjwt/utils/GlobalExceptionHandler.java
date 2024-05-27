package dev.priyanshuvishnoi.springsecurityjwt.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<GlobalApiResponse<Object>> handleRuntimeException(RuntimeException e) {
        return new ResponseEntity<>(new GlobalApiResponse<>(true, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalApiResponse<Object>> handleException(Exception e) {
        return new ResponseEntity<>(new GlobalApiResponse<>(true, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
