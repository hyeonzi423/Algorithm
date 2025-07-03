import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            int[][] map = new int[N + 1][M + 1]; 
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[N + 1][M + 1];
            int ans = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] == 1) {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),
                                            dp[i-1][j-1]) + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}