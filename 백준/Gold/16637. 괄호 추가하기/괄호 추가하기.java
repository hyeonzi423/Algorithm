import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, ans;
	static char input[];
	static boolean isSelected[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new char[N];
		input = br.readLine().toCharArray();

		ans = Integer.MIN_VALUE;
		dfs(2, input[0] - '0');
		System.out.println(ans);
	}

	public static void dfs(int idx, int sum) {
		if (idx >= N) {
			ans = Math.max(ans, sum);
			return;
		}
		dfs(idx + 2, cal(sum, input[idx] - '0', input[idx - 1]));
		if (idx + 2 < N) {
			int res = cal(input[idx] - '0', input[idx + 2] - '0', input[idx + 1]);
			dfs(idx + 4, cal(sum, res, input[idx - 1]));
		}
	}

	public static int cal(int a, int b, char o) {
		if (o == '+') {
			return a + b;
		} else if (o == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}
}