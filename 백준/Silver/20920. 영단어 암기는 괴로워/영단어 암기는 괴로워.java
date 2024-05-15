import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			if (s.length() < m)
				continue;
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		List<String> words = new ArrayList<>(map.keySet());

		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
					return Integer.compare(map.get(o2), map.get(o1));
				}
				if (o1.length() != o2.length()) {
					return o2.length() - o1.length();
				}
				return o1.compareTo(o2);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (String str : words) {
			sb.append(str + "\n");
		}
		System.out.println(sb);
	}
}