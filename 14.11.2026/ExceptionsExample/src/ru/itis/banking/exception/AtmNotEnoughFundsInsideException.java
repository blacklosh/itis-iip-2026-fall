package ru.itis.banking.exception;

public class AtmNotEnoughFundsInsideException extends AtmBankingException {

    public AtmNotEnoughFundsInsideException() {
        super("В банкомате недостаточно наличных для выдачи");
    }
}
