import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] numbers;
	static int[] combination;
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] str = br.readLine().split(" ");
			k = Integer.parseInt(str[0]);

			if (k == 0) {
				break;
			}

			numbers = new int[k];
			combination = new int[6];

			for (int i = 0; i < k; i++) {
				numbers[i] = Integer.parseInt(str[i + 1]);
			}

			combi(0, 0);
			System.out.println();
		}
	}

	public static void combi(int start, int depth) {
		if (depth == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(combination[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < k; i++) {
			combination[depth] = numbers[i];
			combi(i + 1, depth + 1);
		}
	}
}