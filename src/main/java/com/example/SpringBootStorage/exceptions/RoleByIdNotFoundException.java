package com.example.SpringBootStorage.exceptions;

/**
 * Exception thrown when 'com.example.SpringBootStorage.entities.Role' data is not found in the database given the id.
 */
public class RoleByIdNotFoundException extends RuntimeException {

    /**
     * Initializes a new RoleByIdNotFoundException with the given message.
     *
     * @param message the error message.
     * @param roleId  the role id used to locate the role.
     */
    public RoleByIdNotFoundException(final String message, final String roleId) {
        super(String.format(message, roleId));
    }

    /**
     * Initializes a new RoleByIdNotFoundException with the given message and cause.
     *
     * @param message the error message.
     * @param cause   of the error - type Throwable.
     */
    public RoleByIdNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
