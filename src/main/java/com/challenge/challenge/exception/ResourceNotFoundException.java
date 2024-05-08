package com.challenge.challenge.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private String resource;

    private String key;

    private String value;

    public ResourceNotFoundException(final String resource, final String key, final String value) {
        super(String.format("Resource %s not found for %s %s", resource, key, value));
        this.resource = resource;
        this.key = key;
        this.value = value;
    }

}