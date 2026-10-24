package cmd.example2;

public class Variant2 {
    public final int age;
    public final boolean b;
    public final String c;
    public final int[] d;

    public Variant2(int age, boolean b, String c, int[] d) {
        if (age <= 0) {
            this.age = 18;
        } else {
            this.age = age;
        }
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
