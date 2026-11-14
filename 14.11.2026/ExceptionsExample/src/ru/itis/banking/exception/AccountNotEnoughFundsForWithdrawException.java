package ru.itis.banking.exception;

public class AccountNotEnoughFundsForWithdrawException extends AccountBankingException {

    public AccountNotEnoughFundsForWithdrawException() {
        super("На балансе аккаунта недостаточно средств для снятия");
    }
}
