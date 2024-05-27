import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static ArrayList<ArrayList<Integer>> friends;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 상근이의 동기 수
		M = Integer.parseInt(br.readLine()); // 리스트의 길이

		friends = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			friends.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			friends.get(A).add(B);
			friends.get(B).add(A);
		}

		ans = 0;
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		for (int f : friends.get(1)) {
			if (!visited[f]) {
				visited[f] = true;
				ans++;
			}
			for (int r : friends.get(f)) {
				if (!visited[r]) {
					visited[r] = true;
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}