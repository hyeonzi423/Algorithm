import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	public static class Word implements Comparable<Word> {
		String word;
		int len, cnt;

		public Word(String word, int len, int cnt) {
			this.word = word;
			this.len = len;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Word o) {
			if (this.cnt != o.cnt) {
				return Integer.compare(o.cnt, this.cnt);
			} else if (this.len != o.len) {
				return Integer.compare(o.len, this.len);
			}
			return this.word.compareTo(o.word);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> set = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String w = br.readLine();
			if (w.length() >= M) {
				if (set.containsKey(w)) {
					set.replace(w, set.get(w) + 1);
				} else {
					set.put(w, 0);
				}
			}
		}

		PriorityQueue<Word> pq = new PriorityQueue<>();
		for (String w : set.keySet()) {
			pq.add(new Word(w, w.length(), set.get(w)));
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			sb.append(pq.poll().word).append("\n");
		}
		
		System.out.println(sb);
	}
}