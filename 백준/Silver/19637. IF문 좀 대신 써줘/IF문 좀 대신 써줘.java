import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

	public static class Level implements Comparable<Level> {
		int idx, value;
		String name;

		public Level(int idx, String name, int value) {
			this.idx = idx;
			this.name = name;
			this.value = value;
		}

		@Override
		public int compareTo(Level o) {
			if (this.value != o.value) {
				return Integer.compare(this.value, o.value);
			}
			return Integer.compare(this.idx, o.idx);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Level> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int value = Integer.parseInt(st.nextToken());
			pq.add(new Level(i, name, value));
		}

		Level[] level = new Level[N];
		for (int i = 0; i < N; i++) {
			level[i] = pq.poll();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int c = Integer.parseInt(br.readLine());
			
			int left = 0, right = N - 1;
			while(left < right) {
				int mid = (left + right)/2;
				right = c <= level[mid].value ? mid : right;
				left = c > level[mid].value ? mid + 1 : left;
			}
			sb.append(level[left].name).append("\n");
		}
		System.out.println(sb);
	}
}
