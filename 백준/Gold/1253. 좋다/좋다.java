import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int ans = 0;

		for (int i = 0; i < N; i++) {
			if (isGood(i)) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	public static boolean isGood(int index) {
		int target = arr[index];

		int left = 0, right = N - 1;

		while (left < right) {
			if (left == index) {
				left++;
				continue;
			}
			if (right == index) {
				right--;
				continue;
			}

			int sum = arr[left] + arr[right];
			if (sum == target) {
				return true;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}
}