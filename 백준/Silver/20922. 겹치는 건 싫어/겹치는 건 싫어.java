import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			while (map.get(nums[i]) > K) {
				map.put(nums[start], map.get(nums[start]) - 1);
				start++;
			}
			max = Math.max(max, i - start + 1);
		}
		System.out.println(max);
	}
}