package org.books.simpleonlinebookstore.web.errorhandling;

import lombok.extern.slf4j.Slf4j;
import org.books.simpleonlinebookstore.exceptions.EntityNotFoundException;
import org.books.simpleonlinebookstore.exceptions.InvalidEntityException;
import org.books.simpleonlinebookstore.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.nio.file.AccessDeniedException;

@ControllerAdvice("org.books.simpleonlinebookstore.web")
@Slf4j
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(EntityNotFoundException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getClass().getSimpleName(), ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentTypeMismatchException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getClass().getSimpleName(), ex.getMessage()));
    }


    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handle(AccessDeniedException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<String> handle(InvalidEntityException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Something went wrong, please try again.");
    }

    @ExceptionHandler({ConstraintViolationException.class, HttpMessageConversionException.class})
    public ResponseEntity<ErrorResponse> handle(Exception ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getClass().getSimpleName(), ex.getMessage()));
    }


}
