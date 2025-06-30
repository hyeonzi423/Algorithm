import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] map = new int[V+1][V+1];
        for(int i = 0; i <= V; i++){
            for(int j = 0; j <= V; j++){
                map[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            map[s][e] = val;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        for (int i = 1; i <= V; i++) {
            if (map[i][i] != Integer.MAX_VALUE) {
                ans = Math.min(ans, map[i][i]);
            }
        }
        
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}