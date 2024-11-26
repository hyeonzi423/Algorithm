import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dis = new int[N - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			dis[i] = Integer.parseInt(st.nextToken());
		}

		int[] cost = new int[N - 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		int minCost = 1000000000;
		long ans = 0;
		for (int i = 0; i < N - 1; i++) {
			if (minCost > cost[i]) {
				minCost = cost[i];
			}
			ans += minCost * dis[i];
		}
		System.out.println(ans);
	}
}