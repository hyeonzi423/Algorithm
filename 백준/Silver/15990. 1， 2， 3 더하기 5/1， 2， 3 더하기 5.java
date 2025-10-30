import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_009L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        int[] qs = new int[T];
        int maxN = 0;
        for (int i = 0; i < T; i++) {
            qs[i] = Integer.parseInt(br.readLine().trim());
            if (qs[i] > maxN) maxN = qs[i];
        }

        long[][] dp = new long[Math.max(4, maxN + 1)][4]; // [n][last], last=1..3

        // base cases
        if (maxN >= 1) dp[1][1] = 1;              // 1
        if (maxN >= 2) dp[2][2] = 1;              // 2
        if (maxN >= 3) {                          // 3: (2+1), (1+2), (3)
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;
        }

        for (int i = 4; i <= maxN; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
        }

        for (int n : qs) {
            long ans = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}