import java.util.*;
import java.io.*;

class Main {

    static int N = 5, ans = 0;
    static char[][] map;
    static int[] selected = new int[7];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        map = new char[N][N];
        for(int i = 0; i < N; i++){
            String st = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = st.charAt(j);
            }            
        }

        dfs(0, 0, 0);
        System.out.println(ans);
    }

    public static void dfs(int start, int depth, int sCnt){
        if(depth == 7){
            if(sCnt >= 4 && isConnected()){
                ans++;   
            }
            return;
        }

        for(int i = start; i < 25; i++){
            int x = i / 5;
            int y = i % 5;

            selected[depth] = i;

            if(map[x][y] == 'S'){
                dfs(i + 1, depth + 1, sCnt + 1);
            }else{
                if(depth - sCnt >= 3) continue;
                dfs(i + 1, depth + 1, sCnt);
            }
        }
    }

        static boolean isConnected() {
        boolean[][] visited = new boolean[5][5];
        Queue<Integer> q = new LinkedList<>();

        int x0 = selected[0] / 5;
        int y0 = selected[0] % 5;
        visited[x0][y0] = true;
        q.offer(selected[0]);

        int count = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();
            int x = cur / 5;
            int y = cur % 5;

            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                int next = nx * 5 + ny;

                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if(visited[nx][ny]) continue;
                if(!contains(next)) continue;

                visited[nx][ny] = true;
                q.offer(next);
                count++;
            }
        }

        return count == 7;
    }

    static boolean contains(int pos) {
        for(int i = 0; i < 7; i++) {
            if(selected[i] == pos) return true;
        }
        return false;
    }
}