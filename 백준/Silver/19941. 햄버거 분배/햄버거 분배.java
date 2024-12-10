import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int ans = 0;
		String line = br.readLine();
		int[] h = new int[N];
		int[] p = new int[N];
		for (int i = 0; i < N; i++) {
			Character c = line.charAt(i);
			if (c == 'H') {
				h[i] = 1;
			} else {
				p[i] = 1;
			}
		}

		for (int i = 0; i < N; i++) {
			if (p[i] == 0)
				continue;
			boolean flag = false;
			for (int j = K; j > 0; j--) {
				if (i - j >= 0) {
					if (h[i - j] == 1) {
						h[i - j] = 0;
						flag = true;
						ans++;
						break;
					}
				}
			}
			if (flag)
				continue;
			for (int j = 1; j <= K; j++) {
				if (i + j < N) {
					if (h[i + j] == 1) {
						h[i + j] = 0;
						ans++;
						break;
					}
				}
			}
		}

		System.out.println(ans);
	}
}