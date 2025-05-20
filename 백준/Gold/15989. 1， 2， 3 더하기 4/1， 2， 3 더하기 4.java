import java.util.*;

public class Main {
    static int[][] dp = new int[10001][4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= 3; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i <= 10000; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    for (int k = 1; k <= j; k++) {
                        dp[i][j] += dp[i - j][k];
                    }
                }
            }
        }

        while (t-- > 0) {
            int n = sc.nextInt();
            int answer = dp[n][1] + dp[n][2] + dp[n][3];
            System.out.println(answer);
        }
    }
}