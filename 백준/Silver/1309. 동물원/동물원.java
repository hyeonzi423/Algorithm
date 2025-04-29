import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int MOD = 9901;
        int[][] dp = new int[N + 1][3];

        dp[1][0] = 1; // 비어있는 경우
        dp[1][1] = 1; // 왼쪽 
        dp[1][2] = 1; // 오른쪽

        for(int i = 2; i <= N; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }
        
        int answer = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;
        System.out.println(answer);
    }
}