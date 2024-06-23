package com.example.SpringBootStorage.exceptions;

/**
 * Exception thrown when 'com.example.SpringBootStorage.entities.StorageDataEntry' data is not found in the database
 */
public class StorageDataNotFoundException extends RuntimeException {

    /**
     * Initializes a new StorageDataNotFoundException with the given message.
     *
     * @param message   the error message.
     * @param qualifier the qualifier used to identify the StorageDataEntry.
     */
    public StorageDataNotFoundException(final String message, final String qualifier) {
        super(String.format(message, qualifier));
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
