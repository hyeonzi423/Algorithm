import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] dp = new long[N][N];
		dp[0][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;

				int right = j + map[i][j];
				int down = i + map[i][j];

				if (right < N) {
					dp[i][right] += dp[i][j];
				}
				if (down < N) {
					dp[down][j] += dp[i][j];
				}
			}
		}

		System.out.println(dp[N - 1][N - 1]);
	}
}
