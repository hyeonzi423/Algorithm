import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1_000_000_003;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if (K == 0) {
            System.out.println(1);
            return;
        }
        if (K == 1) {
            System.out.println(N);
            return;
        }
        if (K > N / 2) {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1; // 0개 선택하는 경우는 항상 1개
            if (i >= 1) dp[i][1] = i; // 1개 선택하는 경우는 i개
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
            }
        }

        // 1번 색을 고른 경우 → 마지막(N번)은 고를 수 없음
        int case1 = dp[N - 3][K - 1];
        // 1번 색을 고르지 않은 경우 → 일반 선형처럼 처리 가능
        int case2 = dp[N - 1][K];

        int result = (case1 + case2) % MOD;
        System.out.println(result);
    }
}