import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[F+1];
        
        q.add(new int[]{S,0});
        visited[S] = true;

        boolean flag = false;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == G){
                System.out.println(now[1]);
                flag = true;
                break;
            }
            if(now[0] + U <= F && !visited[now[0] + U]){
                visited[now[0] + U] = true;
                q.add(new int[]{now[0] + U, now[1] + 1});
            }
            if(now[0] - D >= 1 && !visited[now[0] - D]){
                visited[now[0] - D] = true;
                q.add(new int[]{now[0] - D, now[1] + 1});
            }
        }
        if(!flag){
            System.out.println("use the stairs");
        }
    }
}