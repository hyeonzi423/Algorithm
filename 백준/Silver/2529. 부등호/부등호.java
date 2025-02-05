import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] permutation;
	static boolean[] visited;
	static String[] order;
	static int N;
	static String max = "0";
	static String min = "9999999999";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()) + 1;
		permutation = new int[N];
		visited = new boolean[10];

		order = br.readLine().split(" ");
		permu(0);

		System.out.println(max);
		System.out.println(min);
	}

	public static void permu(int depth) {
		if (depth == N) {
			String num = "";
			for (int i = 0; i < N; i++) {
				num += permutation[i] + "";
			}
			if (Long.parseLong(max) < Long.parseLong(num)) {
				max = num;
			}
			if (Long.parseLong(min) > Long.parseLong(num)) {
				min = num;
			}
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (!visited[i]) {
				if (depth > 0 && !check(depth - 1, depth, i)) {
					continue;
				}
				visited[i] = true;
				permutation[depth] = i;
				permu(depth + 1);
				visited[i] = false;
			}
		}
	}

	public static boolean check(int orderIdx, int depth, int now) {
		if (order[orderIdx].equals("<")) {
			if (permutation[depth - 1] < now) {
				return true;
			}
		} else {
			if (permutation[depth - 1] > now) {
				return true;
			}
		}
		return false;
	}
}