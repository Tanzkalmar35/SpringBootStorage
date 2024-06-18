package com.example.SpringBootStorage.exceptions;

/**
 * Exception thrown when 'com.example.SpringBootStorage.entities.StorageDataEntry' data is not found in the database
 */
public class StorageDataNotFoundException extends RuntimeException {

    /**
     * Initializes a new StorageDataNotFoundException with the given message.
     *
     * @param message the error message.
     */
    public StorageDataNotFoundException(final String message) {
        super(message);
    }

    /**
     * Initializes a new StorageDataNotFoundException with the given message and cause.
     *
     * @param message the error message.
     * @param cause   of the error - type Throwable.
     */
    public StorageDataNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
