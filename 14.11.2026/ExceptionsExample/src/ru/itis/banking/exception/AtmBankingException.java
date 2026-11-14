package ru.itis.banking.exception;

public class AtmBankingException extends BankingException {

    public AtmBankingException(String message) {
        super(message, ExceptionType.ATM);
    }
}
