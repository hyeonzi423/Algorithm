import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine().trim());

        // blockedRight[x][y] : (x,y) -> (x+1,y) 로 가는 간선이 막힘
        // blockedUp[x][y]    : (x,y) -> (x,y+1) 로 가는 간선이 막힘
        boolean[][] blockedRight = new boolean[N+1][M+1];
        boolean[][] blockedUp    = new boolean[N+1][M+1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (a == c) { // 세로 간선 (위아래)
                // (a, min(b,d)) -> (a, min(b,d)+1)이 막힘
                int y = Math.min(b, d);
                blockedUp[a][y] = true;
            } else if (b == d) { // 가로 간선 (좌우)
                // (min(a,c), b) -> (min(a,c)+1, b)이 막힘
                int x = Math.min(a, c);
                blockedRight[x][b] = true;
            }
        }

        long[][] dp = new long[N+1][M+1];
        dp[0][0] = 1L;

        for (int x = 0; x <= N; x++) {
            for (int y = 0; y <= M; y++) {
                if (x == 0 && y == 0) continue;

                long ways = 0L;

                // 왼쪽에서 오는 경우: (x-1, y) -> (x, y)
                if (x > 0 && !blockedRight[x-1][y]) {
                    ways += dp[x-1][y];
                }

                // 아래에서 오는 경우: (x, y-1) -> (x, y)
                if (y > 0 && !blockedUp[x][y-1]) {
                    ways += dp[x][y-1];
                }

                dp[x][y] = ways;
            }
        }

        System.out.println(dp[N][M]);
    }
}