import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] num = br.readLine().split(" ");
		int[] nums = new int[n+1];
		int[] dp = new int[n+1];

		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(num[i-1]);
            dp[i] = nums[i];
		}
		
		int ans = 1;
		for(int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + nums[i]);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}