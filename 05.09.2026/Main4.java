public class Main4 {
	public static void main(String[] args) {
		int a = 5;
		
		int b = 1;
		int i = 1;
		for (;;) {
			b = b * i;
			i = i + 1;
			if (i > a) {
				break;
			}
		}
		
		System.out.println(b);
	}
}
