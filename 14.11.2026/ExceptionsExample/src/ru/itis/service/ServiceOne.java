package ru.itis.service;

import ru.itis.exception.MyOwnException;

import java.io.IOException;

public class ServiceOne {

    private final ServiceTwo two;

    public ServiceOne(ServiceTwo two) {
        this.two = two;
    }

    public boolean proxy(String str) {
        try {
            return two.isValidString(str);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Афигеть, делёжка не получилась! " + e.getMessage());
        } catch (MyOwnException e) {
            System.out.println("Proxy failed: " + e.getMessage() +
                    " (code " + e.getStatusCode() + ")");
            return false;
        }

        throw new RuntimeException("Неоднозначный RuntimeException!");
    }

}
