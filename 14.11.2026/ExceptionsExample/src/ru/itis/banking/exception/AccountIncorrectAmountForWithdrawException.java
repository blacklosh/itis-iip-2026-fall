package ru.itis.banking.exception;

public class AccountIncorrectAmountForWithdrawException extends AccountBankingException {

    public AccountIncorrectAmountForWithdrawException(int amount) {
        super("Некорректная сумма для снятия наличных: " + amount);
    }
}
