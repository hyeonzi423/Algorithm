import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		int[] M = new int[N];
		
		int max = 0;
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
			M[i] = Integer.parseInt(st2.nextToken());
			max += M[i];
		}
		
		int[][] dp = new int[N][max+1];
		for(int i = M[0]; i <= max; i++) {
			dp[0][i] = A[0];
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j <= max; j++) {
				if(j-M[i] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-M[i]] + A[i]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		for(int i = 0; i<=max; i++) {
            if (dp[N-1][i] >= K) {
                System.out.println(i);
                break;
            }
        }
	}

}