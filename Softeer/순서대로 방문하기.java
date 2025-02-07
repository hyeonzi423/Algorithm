import java.io.*;
import java.util.*;

public class Main {

    static int N, M, ans = 0;
    static int[][] map;
    static int[][] mustVisit;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        mustVisit = new int[M][2];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            mustVisit[i][0] = Integer.parseInt(st.nextToken()) - 1;
            mustVisit[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        dfs(1, mustVisit[0][0], mustVisit[0][1]);

        System.out.println(ans);

    }

    public static void dfs(int idx, int nowX, int nowY){
        if(nowX == mustVisit[idx][0] && nowY == mustVisit[idx][1]){
            if(idx == M-1){
                ans++;
                return;
            }
            idx++;
        }

        visited[nowX][nowY] = true;

        for(int i = 0; i < 4; i++){
            int nx = nowX + dx[i];
            int ny = nowY + dy[i];

            if(0 > nx || nx >= N || 0 > ny || ny >= N){
                continue;
            }if(visited[nx][ny]){
                continue;
            }if(map[nx][ny] == 1){
                continue;
            }
            dfs(idx, nx, ny);
        }

        visited[nowX][nowY] = false;
    }
}

