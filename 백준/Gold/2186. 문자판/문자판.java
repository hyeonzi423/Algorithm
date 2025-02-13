import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static char[][] map;
    static String word;
    static int[][][] dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        word = br.readLine();
        dp = new int[N][M][word.length()];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == word.charAt(0)) {
                    ans += dfs(i, j, 0);
                }
            }
        }

        System.out.println(ans);
    }

    public static int dfs(int x, int y, int idx) {
        if (idx == word.length() - 1) return 1;
        if (dp[x][y][idx] != -1) return dp[x][y][idx];

        dp[x][y][idx] = 0;

        for (int d = 0; d < 4; d++) {
            for (int k = 1; k <= K; k++) {
                int nx = x + k * dx[d];
                int ny = y + k * dy[d];

                if (!inRange(nx, ny) || map[nx][ny] != word.charAt(idx + 1)) {
                    continue;
                }

                dp[x][y][idx] += dfs(nx, ny, idx + 1);
            }
        }

        return dp[x][y][idx];
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}