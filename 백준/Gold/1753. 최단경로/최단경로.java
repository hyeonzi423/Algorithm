import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 정점 수
		int E = Integer.parseInt(st.nextToken()); // 간선 수
		int K = Integer.parseInt(br.readLine()); // 시작 정점

		ArrayList<int[]>[] edges = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[u].add(new int[] { v, w });
		}

		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[0] - o2[0];
		});
		pq.add(new int[] { 0, K });

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (now[0] != dist[now[1]]) continue; // 현재 최단거리가 아니라면 넘어감

			for (int[] next : edges[now[1]]) {
				int newDist = now[0] + next[1];
				if (newDist < dist[next[0]]) {
					dist[next[0]] = newDist;
					pq.add(new int[] { newDist, next[0] });
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			System.out.println(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF");
		}
	}
}
