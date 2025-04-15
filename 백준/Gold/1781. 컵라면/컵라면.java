import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static class Problem implements Comparable<Problem> {
		int deadLine, value;

		public Problem(int deadline, int value) {
			this.deadLine = deadline;
			this.value = value;
		}

		@Override
		public int compareTo(Main.Problem o) {
			return this.deadLine - o.deadLine;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Problem> problems = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			problems.add(new Problem(d, v));
		}

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		while (!problems.isEmpty()) {
			Problem now = problems.poll();
			pq.offer(now.value);
			if (pq.size() > now.deadLine) {
				pq.poll();
			}
		}

		int ans = 0;
		while (!pq.isEmpty()) {
			ans += pq.poll();
		}

		System.out.println(ans);
	}
}