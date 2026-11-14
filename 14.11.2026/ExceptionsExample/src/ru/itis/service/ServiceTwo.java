package ru.itis.service;

import ru.itis.exception.MyOwnException;

public class ServiceTwo {

    public void parseString(String str) throws MyOwnException {
        if(str.equals("kill")) {
            int a = 1 / 0;
            throw new MyOwnException("ты зачем передал строку kill???", 500);
        }

        System.out.println("Всё в порядке");
    }

    public boolean isValidString(String str) throws MyOwnException {
        parseString(str);
        return true;
    }

}
