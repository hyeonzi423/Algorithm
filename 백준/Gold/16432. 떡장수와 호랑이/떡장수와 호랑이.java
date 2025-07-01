import java.util.*;
import java.io.*;

class Main {

    static int day;
    static ArrayList<Integer>[] food;
    static int[] answer;
    static boolean[][] visited;
    static boolean found = false;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        day = Integer.parseInt(br.readLine());

        food = new ArrayList[day];
        for(int i = 0; i < day; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            
            food[i] = new ArrayList<>();
            for(int j = 0; j < N; j++){
                food[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        answer = new int[day];
        visited = new boolean[day][11];
        
        dfs(0, 0);

        if(!found){
            System.out.println(-1);
        }
    }

    public static void dfs(int now, int prev){
        if(found){
            return;
        }

        if(now == day){
            for(int i = 0; i < day; i++){
                System.out.println(answer[i]);
            }
            found = true;
            return;
        }

        if(visited[now][prev]) return;
        visited[now][prev] = true;

        for(int n : food[now]){
            if(n == prev) continue;

            answer[now] = n;
            dfs(now + 1, n);
        }
    }
}