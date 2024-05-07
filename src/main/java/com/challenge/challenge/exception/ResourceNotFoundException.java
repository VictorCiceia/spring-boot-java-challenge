package com.challenge.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ResourceNotFoundException extends ResponseStatusException {
    public ResourceNotFoundException(final String resource, final String key, final String value) {
        super(HttpStatus.NOT_FOUND, "Resource " + resource + " not found for " + key + " " + value);
    }
}