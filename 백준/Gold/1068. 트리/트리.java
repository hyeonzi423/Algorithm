import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 0, N;
	static int[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new int[N];

		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			list[i] = p;
		}

		int d = Integer.parseInt(br.readLine());

		dfs(d);

		for (int i = 0; i < N; i++) {
			if (list[i] != -2) {
				boolean check = true;
				for (int j = 0; j < N; j++) {
					if (i == list[j]) {
						check = false;
						break;
					}
				}
				if (check)
					cnt += 1;
			}
		}

		System.out.println(cnt);
	}

	public static void dfs(int delete) {
		list[delete] = -2;
		for (int i = 0; i < N; i++) {
			if (delete == list[i]) {
				dfs(i);
			}
		}
	}

}