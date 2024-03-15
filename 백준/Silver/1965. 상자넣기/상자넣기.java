import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[N];
		Arrays.fill(dp, 1);
		
		int ans = 0;
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(input[i] > input[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}

}