import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] input = new int[N + 1];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			input[i] = a;
			input[i + 1] = b;
		}

		int[][] dp = new int[N][N];
		for (int i = 2; i < N + 1; i++) {
			for (int j = 0; j < N - i + 1; j++) { 
				dp[j][j + i - 1] = Integer.MAX_VALUE;
				for (int k = j; k < j + i - 1; k++) { 
					int value = dp[j][k] + dp[k + 1][j + i - 1] + (input[j] * input[k + 1] * input[j + i]);
					dp[j][j + i - 1] = Math.min(dp[j][j + i - 1], value);
				}
			}
		}
		System.out.println(dp[0][N - 1]);
	}
}