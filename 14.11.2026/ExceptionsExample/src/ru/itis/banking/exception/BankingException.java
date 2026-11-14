package ru.itis.banking.exception;

public class BankingException extends Exception {

    private final ExceptionType exceptionType;

    public BankingException(String message, ExceptionType type) {
        super(message);
        exceptionType = type;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    @Override
    public String toString() {
        return "Исключение { type = " + exceptionType.name()
                + ", message = " + getMessage() + " }";
    }

}
