import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

	public static class Node {
		int idx, cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		int[] dis = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
			dis[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));

		}

		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		pq.add(new Node(1, 0));
		dis[1] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (!visited[now.idx]) {
				visited[now.idx] = true;
			}

			for (Node next : graph.get(now.idx)) {
				if (!visited[next.idx] && dis[next.idx] > now.cost + next.cost) {
					dis[next.idx] = now.cost + next.cost;
					pq.add(new Node(next.idx, dis[next.idx]));
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			ans = Math.min(ans, dis[i]);
		}
		System.out.println(dis[N]);
	}
}