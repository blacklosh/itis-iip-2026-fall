public class Main3 {
	public static void main(String[] args) {
		int a = 5;
		
		int b = a;
		while (a > 1) {
			a = a - 1;
			b = b * a;
		}
		
		System.out.println(b);
	}
}
