package ru.itis.exception;

public class MyOwnException extends Exception {

    private final int statusCode;

    public MyOwnException(String message, int status) {
        super(message);
        statusCode = status;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
