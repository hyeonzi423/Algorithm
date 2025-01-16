import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		ArrayList<int[]> shortcuts = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (e <= D) {
				shortcuts.add(new int[] { s, e, d });
			}
		}

		int[] dp = new int[D + 1];
		for (int i = 0; i < D + 1; i++) {
			dp[i] = i;
		}

		for (int i = 0; i <= D; i++) {
			if (i > 0) {
				dp[i] = Math.min(dp[i], dp[i - 1] + 1);
			}
			for (int[] s : shortcuts) {
				if (i == s[0]) {
					dp[s[1]] = Math.min(dp[s[1]], dp[i] + s[2]);
				}
			}
		}
		System.out.println(dp[D]);
	}
}