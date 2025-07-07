import java.util.*;
import java.io.*;

class Main {
    
    private static int N, M;
    private static char[][] map;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            map[i] = line.toCharArray();
        }
        
         if (!isSafe()) {
            System.out.println(0); 
            return;
        }

        installFence();

        System.out.println(1);        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static boolean isSafe(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 'W'){
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if (map[nx][ny] == 'S') return false;
                    }
                }
            }
        }
        return true;
    }

    public static void installFence() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'W') {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if (map[nx][ny] == '.') map[nx][ny] = 'D';
                    }
                }
            }
        }
    }
}