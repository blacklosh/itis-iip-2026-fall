package ru.itis;

import ru.itis.service.ServiceOne;
import ru.itis.service.ServiceTwo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        ServiceTwo two = new ServiceTwo();
        ServiceOne one = new ServiceOne(two);

//        try {
//            one.proxy(str);
//        } catch (Exception exception) {
//            System.out.println("На всякий случай");
//        }
        one.proxy(str);
    }
}
