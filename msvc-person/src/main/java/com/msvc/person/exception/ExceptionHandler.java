package com.msvc.person.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest) {
        Map<String, Object> objectBody = new LinkedHashMap<>();
        objectBody.put("current timestamp", new Date());
        objectBody.put("status", httpStatus.value());

        // Get all errors
        /*List<String> exceptionalErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getField() + ": " + x.getDefaultMessage())
                .collect(Collectors.toList());*/

        Map<String, String> exceptionalErrors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            exceptionalErrors.put(fieldName, errorMessage);
        });

        objectBody.put("errors", exceptionalErrors);

        return new ResponseEntity<>(objectBody, httpStatus);
    }
}
