import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] map = new int[n][m];
        int[][][] dp = new int[n][m][3];
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                Arrays.fill(dp[i][j], (int)1e9);
            }
        }
        
        for(int j = 0; j < m; j++) {
            for(int k = 0; k < 3; k++){
                dp[0][j][k] = map[0][j];
            }
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(j == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + map[i][j];
                } else if(j == m - 1) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + map[i][j];
                    dp[i][j][1] = dp[i - 1][j][2] + map[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + map[i][j];
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++) {
            for (int i = 0; i < 3; i++) {
                min = Math.min(min, dp[n - 1][j][i]);
            }
        }
        System.out.println(min);
    }
}