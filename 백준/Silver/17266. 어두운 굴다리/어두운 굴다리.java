import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] pos = new int[M];
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			pos[i] = Integer.parseInt(st.nextToken());
			if (i == 0) {
				ans = pos[i];
			} else {
				int dis = (pos[i] - pos[i - 1]) % 2 == 0 ? (pos[i] - pos[i - 1]) / 2 : (pos[i] - pos[i - 1]) / 2 + 1;
				ans = Math.max(ans, dis);
			}
		}
		ans = Math.max(ans, N - pos[M - 1]);
		System.out.println(ans);
	}
}