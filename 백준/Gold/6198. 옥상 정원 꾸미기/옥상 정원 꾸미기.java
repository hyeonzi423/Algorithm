import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] h = new long[N];
		for (int i = 0; i < N; i++) {
			h[i] = Long.parseLong(br.readLine());
		}

		long ans = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (h[i] > h[j])
					ans++;
				else
					break;
			}
		}
		System.out.println(ans);
	}

}