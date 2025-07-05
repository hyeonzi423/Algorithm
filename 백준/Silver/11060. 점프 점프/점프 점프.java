import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(new int[] {0, 0});
        visited[0] = true;

        int ans = -1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == N - 1){
                ans = now[1];
                break;
            }

            int max = map[now[0]];
            for(int i = 1; i <= max; i++){
                int next = now[0] + i;
                if(next < N && !visited[next]){
                    visited[next] = true;
                    q.add(new int[] {next, now[1] + 1});
                }
            }
        }

        System.out.println(ans);
    }
}