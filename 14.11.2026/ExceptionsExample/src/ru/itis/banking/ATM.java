package ru.itis.banking;

import ru.itis.banking.exception.AtmIncorrectWithdrawAmountException;
import ru.itis.banking.exception.AtmNotEnoughFundsInsideException;

public class ATM {

    private int amount;

    public ATM(int initialAmount) {
        amount = initialAmount;
    }

    // все купюры по 100 коинов

    public void withdraw(int amount) throws AtmIncorrectWithdrawAmountException,
                                            AtmNotEnoughFundsInsideException {
        if (amount <= 0) {
            throw new AtmIncorrectWithdrawAmountException();
        }
        if (amount % 100 != 0) {
            throw new AtmIncorrectWithdrawAmountException();
        }
        if (this.amount < amount) {
            throw new AtmNotEnoughFundsInsideException();
        }
        this.amount -= amount;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "amount=" + amount +
                '}';
    }
}
