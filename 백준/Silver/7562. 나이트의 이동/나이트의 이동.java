import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        for(int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            q.add(new int[]{startX, startY, 0});
            visited[startX][startY] = true;

            while(!q.isEmpty()){
                int[] now = q.poll();
                if(now[0] == endX && now[1] == endY){
                    sb.append(now[2]).append("\n");
                    break;
                }
                
                for(int i = 0; i < 8; i++){
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                        continue;
                    }if(visited[nx][ny]){
                        continue;
                    }
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, now[2] + 1});
                }
            }
        }
        
        System.out.println(sb);
    }
}