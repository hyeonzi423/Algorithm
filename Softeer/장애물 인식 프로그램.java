import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = (int) str.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Integer> cnt = new PriorityQueue<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    int tmpCnt = 1;

                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                                continue;
                            }if(visited[nx][ny] || map[nx][ny] == 0){
                                continue;
                            }
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            tmpCnt++;
                        }
                    }
                    cnt.add(tmpCnt);
                }
            }
        }

        System.out.println(cnt.size());
        while(!cnt.isEmpty()){
            System.out.println(cnt.poll());
        }
    }
}
