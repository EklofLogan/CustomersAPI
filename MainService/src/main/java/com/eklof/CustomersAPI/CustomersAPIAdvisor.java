package com.eklof.CustomersAPI;

import com.eklof.CustomersAPI.exceptions.DuplicateCustomerException;
import com.eklof.CustomersAPI.exceptions.NoSuchCustomerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomersAPIAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NoSuchCustomerException.class)
    public ResponseEntity<Object> handleNoSuchCustomerException(NoSuchCustomerException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Customer not found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DuplicateCustomerException.class)
    public ResponseEntity<Object> handleDuplicateCustomerException(DuplicateCustomerException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Customer with this information already exists");

        return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);
    }
}
