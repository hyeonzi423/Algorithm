import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] front = new int[N + 1];
		int min = 11, idx = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			front[i] = Integer.parseInt(st.nextToken());
			if (front[i] < min) {
				min = front[i];
				idx = i;
			}
		}

		int[] ans = new int[N];
		boolean[] visited = new boolean[N + 1];
		ans[0] = idx;
		visited[idx] = true;
		int cnt = 1;

		for (int i = 0; i < N - 1; i++) {
			for (int j = 1; j <= N; j++) {
				if (visited[j])
					continue;

				int tmpFront = 0;
				for (int k = 0; k < cnt; k++) {
					if (ans[k] > j)
						tmpFront++;
				}

				if (tmpFront == front[j]) {
					ans[cnt] = j;
					cnt++;
					visited[j] = true;
					break;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}