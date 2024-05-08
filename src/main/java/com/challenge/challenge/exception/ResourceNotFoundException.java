package com.challenge.challenge.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * Exception thrown when a requested resource is not found.
 */
@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private String resource;

    private String key;

    private String value;

    /**
     * Constructs a new ResourceNotFoundException with the specified resource, key, and value.
     *
     * @param resource the type of resource that was not found ("Booking", "User", etc.)
     * @param key      the key associated with the resource ("ID", "Name", etc.)
     * @param value    the value that was used to search for the resource
     */
    public ResourceNotFoundException(final String resource, final String key, final String value) {
        super(String.format("Resource %s not found for %s %s", resource, key, value));
        this.resource = resource;
        this.key = key;
        this.value = value;
    }

}