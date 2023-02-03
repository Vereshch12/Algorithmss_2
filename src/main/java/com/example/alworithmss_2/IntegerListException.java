package com.example.alworithmss_2;

public class IntegerListException extends Throwable {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public IntegerListException(String message) {
        super(message);
    }
}
