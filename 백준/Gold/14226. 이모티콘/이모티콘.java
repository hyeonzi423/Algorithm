import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        int N = Integer.parseInt(br.readLine());
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0, 0}); // 현재 수, 클립보드 수, 시간
        boolean[][] visited = new boolean[2001][2001];
        visited[1][0] = true;
        
        int ans = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int s = now[0], c = now[1], t = now[2];
            
            if(s == N){
                System.out.println(t);
                break;
            }
            
            if(!visited[s][s]){
                visited[s][s] = true;
                q.add(new int[]{s, s, t + 1});
            }
            if(c > 0 && s + c < visited.length && !visited[s + c][c]){
                visited[s + c][c] = true;
                q.add(new int[]{s + c, c, t + 1});
            }
            if(s - 1 > 0 && !visited[s - 1][c]){
                visited[s - 1][c] = true;
                q.add(new int[]{s - 1, c, t + 1});
            }
        }
    }
}
