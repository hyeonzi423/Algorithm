import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 곡의 개수
        int S = Integer.parseInt(st.nextToken()); // 시작 볼륨
        int M = Integer.parseInt(st.nextToken()); // 최대값

        int[] values = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i][j]) {
                    if (j + values[i] <= M) {
                        dp[i + 1][j + values[i]] = true;
                    }
                    if (j - values[i] >= 0) {
                        dp[i + 1][j - values[i]] = true;
                    }
                }
            }
        }

        int ans = -1;
        for (int j = M; j >= 0; j--) {
            if (dp[N][j]) {
                ans = j;
                break;
            }
        }

        System.out.println(ans);
    }
}