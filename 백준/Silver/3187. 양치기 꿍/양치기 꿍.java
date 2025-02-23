import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int totalWolf = 0;
        int totalSheep = 0;
        
        char[][] map = new char[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);    
                totalWolf += map[i][j] == 'v' ? 1 : 0;
                totalSheep += map[i][j] == 'k' ? 1 : 0;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != '#' && !visited[i][j]){
                    q.clear();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    int wolf = map[i][j] == 'v' ? 1 : 0;
                    int sheep = map[i][j] == 'k' ? 1 : 0;

                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if(0 > nx || nx >= N || 0 > ny || ny >= M){
                                continue;
                            }if(visited[nx][ny] || map[nx][ny] == '#'){
                                continue;
                            }
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                            wolf += map[nx][ny] == 'v' ? 1 : 0;
                            sheep += map[nx][ny] == 'k' ? 1 : 0;
                        }
                    }
                    if(wolf < sheep){
                        totalWolf -= wolf;
                    }else{
                        totalSheep -= sheep;
                    }
                }
            }
        }
        System.out.println(totalSheep + " " + totalWolf);
    }
}