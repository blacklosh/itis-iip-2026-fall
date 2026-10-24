package cmd.example2;

public class Main2 {

    public static void main(String[] args) {
        Variant4 v = new Variant4(1,
                true,
                "",
                new int[]{1, 2, 3});

        v.d()[1] = 1;

        v.sayAge();

        System.out.println(v.d()[1]);
    }
}
