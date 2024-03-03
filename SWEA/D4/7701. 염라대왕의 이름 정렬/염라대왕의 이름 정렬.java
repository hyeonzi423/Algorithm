import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() != o2.length()) {
						return o1.length() - o2.length();
					} else {
						for (int i = 0; i < o1.length(); i++) {
							if (o1.charAt(i) != o2.charAt(i)) {
								return o1.charAt(i) - o2.charAt(i);
							}
						}
					}
					return 0;
				}
			});
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				if (!set.contains(str)) set.add(str);
			}

			sb.append("#").append(tc).append("\n");
			int s = set.size();
			for (int i = 0; i < s; i++) {
				sb.append(set.pollFirst()).append("\n");
			}
		}
		System.out.println(sb);
	}

}