import java.util.Scanner;

public class Main6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Привет! Как тебя зовут?");
		String name = sc.nextLine();
		System.out.println("А сколько тебе лет?");
		int age = sc.nextInt();
		System.out.println(
			"Приятно познакомиться, " +
			name + ", которому " + age + " лет"
		);
	}
}
