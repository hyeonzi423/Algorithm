import java.util.*;
import java.io.*;

class Main {

    static int N, K, ans;
    static int[][] time;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        time = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    time[i][j] = Math.min(time[i][j], time[i][k] + time[k][j]);
                }
            }
        }

        visited = new boolean[N];
        ans = Integer.MAX_VALUE;

        visited[K] = true;
        dfs(K, 1, 0);
        
        System.out.println(ans);
    }

    public static void dfs(int now, int depth, int sumTime){
        if(depth == N){
            ans = Math.min(ans, sumTime);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1, sumTime + time[now][i]);
                visited[i] = false;  // 백트래킹
            }
        }
    }
}