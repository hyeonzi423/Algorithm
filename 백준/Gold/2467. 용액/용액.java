import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] nums = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}

		int left = 0, right = N - 1;
		long value;
		long ansL = -1, ansR = -1;
		long minValue = 2000000000L;
		while (left < right) {
			value = nums[left] + nums[right];
			if (minValue >= Math.abs(value)) {
				minValue = Math.abs(value);
				ansL = nums[left];
				ansR = nums[right];
			}
			if (value > 0) {
				right--;
			} else if (value < 0) {
				left++;
			} else {
				break;
			}
		}
		System.out.println(ansL + " " + ansR);
	}
}