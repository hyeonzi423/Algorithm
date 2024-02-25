import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int parent[], N, map[][];

	static class Planet implements Comparable<Planet> {
		int from, to, cost;

		public Planet(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Planet o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		PriorityQueue<Planet> planets = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (map[i][j] > 0) {
					planets.offer(new Planet(i, j, map[i][j]));
				}
			}
		}

		makeSet(N);
		int cnt = 0;
		long ans = 0;
		if(planets.size() == 0) {
			System.out.println(0);
		}else {
			while (true) {
				Planet edge = planets.poll();
				if (union(edge.from, edge.to)) {
					cnt++;
					ans += edge.cost;
				}
				if (cnt == N - 1) {
					System.out.println(ans);
					break;
				}
			}
		}
	}

	public static void makeSet(int x) {
		parent = new int[x];
		for (int i = 0; i < x; i++) {
			parent[i] = i;
		}
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;
		parent[b] = a;
		return true;
	}
}