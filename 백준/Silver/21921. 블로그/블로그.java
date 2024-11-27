import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] day = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			day[i] = Integer.parseInt(st.nextToken());
		}

		int now = 0;
		for (int i = 0; i < X; i++) {
			now += day[i];
		}

		int max = now, cnt = 1;
		for (int i = X; i < N; i++) {
			now = now + day[i] - day[i - X];
			if (now > max) {
				cnt = 1;
				max = now;
			} else if (now == max) {
				cnt++;
			}

		}
		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}