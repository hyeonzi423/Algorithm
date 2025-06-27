import java.util.*;
import java.io.*;

class Main {

    static int N, M, A, B;
    static boolean[][] blocked = new boolean[101][101];
    static List<int[]> items = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for(int i = 0; i < A; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            items.add(new int[]{x, y});
        }

        for(int i = 0; i < B; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            blocked[x][y] = true;
        }

        items.add(new int[]{0, 0});
        items.add(new int[]{N-1, M-1});
        items.sort((a, b) ->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        long ans = 1;
        for(int i = 0; i < items.size() - 1; i++){
            int[] start = items.get(i);
            int[] end = items.get(i + 1);
            ans *= findPaths(start[0], start[1], end[0], end[1]);
        }

        System.out.println(ans);
    }

    public static int findPaths(int sx, int sy, int ex, int ey){
        if(sx > ex || sy > ey) return 0;

        int[][] dp = new int[N][M];
        if (blocked[sx][sy]) return 0;
        dp[sx][sy] = 1;

        for(int i = sx; i <= ex; i++){
            for(int j = sy; j <= ey; j++){
                if(blocked[i][j]){
                    dp[i][j] = 0;
                    continue;
                }
                if(i > sx) dp[i][j] += dp[i-1][j];
                if(j > sy) dp[i][j] += dp[i][j-1];
            }
        }

        return dp[ex][ey];
    }
}