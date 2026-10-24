package cmd.example2;

import java.util.Arrays;

public class Variant3 {
    private final int age;
    private final boolean b;
    private final String c;
    private final int[] d;

    public Variant3(int age, boolean b, String c, int[] d) {
        if (age <= 0) {
            this.age = 18;
        } else {
            this.age = age;
        }
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getAge() {
        return age;
    }

    public boolean isB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public int[] getD() {
        return Arrays.copyOf(d, d.length);
    }
}
