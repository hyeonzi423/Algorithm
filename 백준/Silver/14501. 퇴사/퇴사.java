import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];  // N+1 크기로 배열 선언 (퇴사일을 포함)
        
        for (int i = 0; i < N; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            int next = i + map[i][0];
            if (next <= N) {
                dp[next] = Math.max(dp[next], dp[i] + map[i][1]);
            }
        }

        System.out.println(dp[N]);
    }
}