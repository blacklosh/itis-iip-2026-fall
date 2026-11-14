package ru.itis.banking.exception;

public class AccountBankingException extends BankingException {

    public AccountBankingException(String message) {
        super(message, ExceptionType.ACCOUNT);
    }
}
