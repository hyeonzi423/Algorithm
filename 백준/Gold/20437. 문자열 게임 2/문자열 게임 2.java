import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());

			HashMap<Character, List<Integer>> hm = new HashMap<>();
			for (int i = 0; i < W.length(); i++) {
				char c = W.charAt(i);
				hm.putIfAbsent(c, new ArrayList<>());
				hm.get(c).add(i);
			}

			int minLen = Integer.MAX_VALUE;
			int maxLen = Integer.MIN_VALUE;

			for (HashMap.Entry<Character, List<Integer>> entry : hm.entrySet()) {
				List<Integer> list = entry.getValue();
				if (list.size() < K)
					continue;

				for (int i = 0; i <= list.size() - K; i++) {
					int len = list.get(i + K - 1) - list.get(i) + 1;
					minLen = Math.min(minLen, len);
					maxLen = Math.max(maxLen, len);
				}
			}

			if (minLen == Integer.MAX_VALUE || maxLen == Integer.MIN_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(minLen + " " + maxLen);
			}
		}
	}
}