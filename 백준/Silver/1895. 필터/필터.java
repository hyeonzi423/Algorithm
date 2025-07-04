import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int T = Integer.parseInt(br.readLine());

        int ans = 0;
        for(int i = 0; i <= N - 3; i++){
            for(int j = 0; j <= M - 3; j++){
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for(int a = 0; a < 3; a++){
                    for(int b = 0; b < 3; b++){
                        pq.add(map[i + a][j + b]);
                    }
                }
                for(int k = 0; k < 4; k++){
                    pq.poll();
                }
                if(pq.peek() >= T){
                    ans++;
                }
            }
        }
        
        System.out.println(ans);
    }
}