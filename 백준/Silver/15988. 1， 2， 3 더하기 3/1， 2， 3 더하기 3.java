import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer T = Integer.parseInt(br.readLine());

		ArrayList<Integer> arr = new ArrayList<>();
		int max = 0;
		for (int t = 0; t < T; t++) {
			int tmp = Integer.parseInt(br.readLine());
			arr.add(tmp);
			max = Math.max(max, tmp);
		}

		int MOD = 1000000009;
		int[] dp = new int[max + 1];
		dp[1] = 1;
		if (max >= 2) dp[2] = 2;
        if (max >= 3) dp[3] = 4;
        
		for(int i = 4; i <= max; i++) {
			dp[i] = ((dp[i - 1] + dp[i - 2]) % MOD + dp[i - 3]) % MOD;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int a : arr) {
			sb.append(dp[a]).append('\n');
		}
		
		System.out.println(sb);
	}
}