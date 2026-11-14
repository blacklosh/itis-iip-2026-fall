package ru.itis.banking;

import ru.itis.banking.exception.AccountIncorrectAmountForWithdrawException;
import ru.itis.banking.exception.AccountNotEnoughFundsForWithdrawException;

public class BankAccount {

    private final String fio;

    private int balance;

    public BankAccount(String fio, int initialBalance) {
        this.fio = fio;
        balance = initialBalance;
    }

    public String getFio() {
        return fio;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "fio='" + fio + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void withdraw(int amount) throws AccountIncorrectAmountForWithdrawException,
                                            AccountNotEnoughFundsForWithdrawException {
        if (amount <= 0) {
            throw new AccountIncorrectAmountForWithdrawException(amount);
        }
        if (amount > balance) {
            throw new AccountNotEnoughFundsForWithdrawException();
        }
        balance -= amount;
    }
}
