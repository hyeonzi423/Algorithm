import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] nums = new int[500][500];
		
		for(int i = 0; i< num; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < str.length; j++) {
				nums[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		int[][] dp = new int[500][500];
		dp[0][0] = nums[0][0];
		int ans = 0;
		for(int i = 1; i < num; i++) {
			for(int j= 0; j < i+1; j++) {
				if (j == 0) {
					dp[i][j] = dp[i-1][j] + nums[i][j];
				}
				else if(j == i) {
					dp[i][j] = dp[i-1][j-1] + nums[i][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + nums[i][j];
				}
				if (i == num-1) {
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		if (num == 1) {
			System.out.println(dp[0][0]);
		}
		else {
			System.out.println(ans);
		}
	}
}