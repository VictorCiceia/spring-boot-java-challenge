package com.challenge.challenge.controller;

import com.challenge.challenge.dto.ExceptionDto;
import com.challenge.challenge.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class ExceptionAdvice {

    final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto resourceNotFoundException(final ResourceNotFoundException e) {
        logger.warn(e.getMessage());
        return new ExceptionDto(new String[]{e.getMessage()}, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString());

    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = new ArrayList<>();
        for (FieldError error : ex.getFieldErrors()) {
            errorMessages.add(error.getDefaultMessage());
        }
        logger.warn(String.join("; ", errorMessages));
        return new ExceptionDto(errorMessages.toArray(new String[0]), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString());
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDto exception(final Exception e) {
        logger.error(e.getMessage());
        return new ExceptionDto(new String[]{e.getMessage()}, HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }

}
