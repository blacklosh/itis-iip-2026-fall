package cmd.example2;

public record Variant4(
        int age,
        boolean b,
        String c,
        int[] d
) {
    public void sayAge() {
        System.out.println("Мне " + age + " лет");
    }
}
