import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {
			int day = Integer.parseInt(br.readLine());
			int[] num = new int[day];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < day; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			long get = 0;
			int max = num[day - 1];
			for (int i = day - 1; i >= 0; i--) {
				if (num[i] < max) {
					get += max - num[i];
				} else {
					max = num[i];
				}
			}
			sb.append(get).append("\n");
		}
		System.out.println(sb);
	}
}