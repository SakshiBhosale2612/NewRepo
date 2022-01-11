
public class Day1 {

	public static void main(String[] args) {
		int k = 6;
		int p = 6;
		for (int i = 0; i < 6; i++) {
			System.out.println();
			p = 6 - k;
			System.out.print("			");
			for (int j = 0; j < p; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < k; j++) {
				System.out.print("*");
				System.out.print(" ");
			}
			k--;

		}
		for (int i = 0; i < 7; i++) {
			p = 7 - 1 - i;
			System.out.print("			");
			for (int j = 0; j < p; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
