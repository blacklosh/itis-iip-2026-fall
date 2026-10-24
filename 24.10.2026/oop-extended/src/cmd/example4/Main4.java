package cmd.example4;

import java.util.HashMap;
import java.util.Map;

public class Main4 {

    public static void main(String[] args) {
        Map<Integer, String> stringsByHash = new HashMap<>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (char first : alphabet.toCharArray()) {
            for (char second : alphabet.toCharArray()) {
                String current = "" + first + second;
                int hash = current.hashCode();

                String previous = stringsByHash.putIfAbsent(hash, current);
                if (previous != null && !previous.equals(current)) {
                    System.out.println("Найдена коллизия:");
                    System.out.println('"' + previous + "\" -> " + previous.hashCode());
                    System.out.println('"' + current + "\" -> " + current.hashCode());
                    return;
                }
            }
        }

        System.out.println("Коллизия не найдена");
    }
}
