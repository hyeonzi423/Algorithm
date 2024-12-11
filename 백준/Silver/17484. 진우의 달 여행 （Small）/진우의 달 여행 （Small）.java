import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    static int[] dir = {-1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < M; i++){
            dfs(0, i, -1, map[0][i]);
        }

        System.out.println(ans);
    }
    
    public static void dfs(int r, int c, int predir, int tmpAns){
        if(r == N-1){
            ans = Math.min(ans, tmpAns);
            return;
        }
        for(int i = 0; i < 3; i++){
            int nc = c + dir[i];
            if(nc >= 0 && nc < M && predir != i){
                dfs(r+1, nc, i, tmpAns + map[r+1][nc]);
            }
        }
    }
}