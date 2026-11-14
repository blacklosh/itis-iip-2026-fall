package ru.itis.banking;

import ru.itis.banking.exception.BankingException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount bankAccount = null;
        ATM atm = null;
        try {
            System.out.println("Введите имя для аккаунта: ");
            String accountName = sc.nextLine();

            System.out.println("Введите изначальный баланс: ");
            int balance = sc.nextInt();

            System.out.println("Введите, сколько наличности в банкомате: ");
            int amountInAtm = sc.nextInt();
            if (amountInAtm % 100 != 0) {
                throw new IllegalArgumentException("Наличность в банкомате должна быть 100 купюрами");
            }

            System.out.println("Предметная область заполнена: ");
            bankAccount = new BankAccount(accountName, balance);
            atm = new ATM(amountInAtm);

            System.out.println(bankAccount);
            System.out.println(atm);

            System.out.println("Сколько будем снимать денег?");
            int cashToWithdrawal = sc.nextInt();

            System.out.println("Провожу операцию снятия...");
            bankAccount.withdraw(cashToWithdrawal);
            atm.withdraw(cashToWithdrawal);
            System.out.println("Операция успешна!");
            System.out.println(bankAccount);
            System.out.println(atm);
        } catch (InputMismatchException e) {
            // Пользователь ввёл некоректные данные
            System.err.println("Введены некорректные данные: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Не удалось запустить банкомат: " + e.getMessage());
        } catch (BankingException e) {
            System.err.println("Банковская операция не удалась:");
            System.err.println(e);
        }

        System.out.println("Состояние системы: ");
        System.out.println(bankAccount);
        System.out.println(atm);

    }
}
