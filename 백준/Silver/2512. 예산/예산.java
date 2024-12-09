import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N];
		int tmp = 0, max = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			tmp += num[i];
			max = Math.max(max, num[i]);
		}
		int total = Integer.parseInt(br.readLine());

		if (tmp <= total) {
			System.out.println(max);
		} else {
			int left = 1, right = max, mid = 0;
			while (left <= right) {
				mid = (left + right) / 2;
				int sum = 0;
				for (int i = 0; i < N; i++) {
					sum += Math.min(num[i], mid);
				}
				if (sum > total) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			System.out.println(right);
		}
	}
}