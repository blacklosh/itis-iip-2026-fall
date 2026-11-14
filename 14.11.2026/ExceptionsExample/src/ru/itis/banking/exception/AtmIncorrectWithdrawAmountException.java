package ru.itis.banking.exception;

public class AtmIncorrectWithdrawAmountException extends AtmBankingException {

    public AtmIncorrectWithdrawAmountException() {
        super("Введённая сумма не может быть выдана банкоматом");
    }
}
