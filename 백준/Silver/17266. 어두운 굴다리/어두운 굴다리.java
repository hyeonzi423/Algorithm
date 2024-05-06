import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 1;
		int right = N;
		int result = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (check(mid)) {
				result = mid;
				right = mid - 1;
			} else
				left = mid + 1;
		}
		System.out.println(result);
	}

	static boolean check(int tmp) {
		int prev = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] - tmp <= prev) {
				prev = arr[i] + tmp;
			} else {
				return false;
			}

		}
		return N - prev <= 0;
	}
}