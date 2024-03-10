import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int indegree[] = new int[v];

		for (int i = 0; i < v; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			graph.get(s).add(e);
			indegree[e]++;
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < v; i++) {
			if (indegree[i] == 0)
				queue.add(i);
		}

		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + 1 + " ");
			for (int next : graph.get(now)) {
				indegree[next]--;
				if (indegree[next] == 0)
					queue.add(next);
			}
		}

	}
}