import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strings = br.readLine().split(" ");
		int N = Integer.parseInt(strings[0]);
		int M = Integer.parseInt(strings[1]);

		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(nums);

		int left = 0;
		int right = 0;
		int ans = Integer.MAX_VALUE;

		while (right < N) {
			int val = nums[right] - nums[left];
			if (val < M) {
				right++;
			} else {
				left++;
				ans = Math.min(ans, val);
			}

			if (left == right) {
				if (right < N) {
					right++;
				}
			}
		}

		System.out.println(ans);
	}
}