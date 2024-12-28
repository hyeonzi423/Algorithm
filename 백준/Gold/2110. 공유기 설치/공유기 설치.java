import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	static int N, C;
	static long[] home;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		home = new long[N];
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);

		long min = 1, max = home[N-1] - home[0], ans = -1;
		
		while (min <= max) {
			long mid = (max + min) / 2;

			if(check(mid) >= C) {
				ans = mid;
				min = mid + 1;
			}else {
				max = mid - 1;
			}
		}
		System.out.println(ans);
	}

	public static int check(long dis) {
		int cnt = 1, build = 0;

		for (int i = 1; i < N; i++) {
			if (home[i] - home[build] >= dis) {
				cnt++;
				build = i;
			}
		}
		return cnt;
	}
}