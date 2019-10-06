package com.anz.wholesale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(value= {RuntimeException.class })
    protected ExceptionData handleRuntimeException(RuntimeException ex, WebRequest request) {
        return new ExceptionData(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage() , LocalDateTime.now());
    }

    @ExceptionHandler(value= { ResponseStatusException.class })
    protected ExceptionData handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        return new ExceptionData(ex.getStatus(), ex.getStatus().value(), ex.getReason() , LocalDateTime.now());
    }

    @ExceptionHandler(value= { MissingServletRequestParameterException.class, NoHandlerFoundException.class })
    protected ExceptionData handleServletException(ServletException ex, WebRequest request) {
        return new ExceptionData(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), ex.getMessage() , LocalDateTime.now());
    }
}
