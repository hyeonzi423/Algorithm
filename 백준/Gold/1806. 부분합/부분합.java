import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = 0, sum = 0, ans = Integer.MAX_VALUE;

		while (true) {
			if (sum >= S) {
				ans = Math.min(ans, right - left);
				sum -= nums[left];
				left++;
			} else {
				if (right == N) {
					break;
				}
				sum += nums[right];
				right++;
			}
		}
		System.out.println(ans != Integer.MAX_VALUE ? ans : 0);
	}
}