import java.util.*;
import java.io.*;

class Main {

    static boolean[] visited;
    static ArrayList<int[]>[] tree;
    static int farNode = 0;
    static int maxDist = 0;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) tree[i] = new ArrayList<>();
        
        for(int i = 0; i < N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[s].add(new int[]{e, w});
            tree[e].add(new int[]{s, w});
        }

        visited = new boolean[N+1];
        dfs(1, 0); // 지름 중 하나의 끝 찾기

        visited = new boolean[N+1];
        maxDist = 0;
        dfs(farNode, 0); // 찾은 한쪽 끝에서 가장 먼 노드를 찾아 지름 찾기
        
        System.out.println(maxDist);
    }

    public static void dfs(int node, int dist){
        visited[node] = true;
        if(dist > maxDist){
            maxDist = dist;
            farNode = node;
        }

        for(int[] edge : tree[node]){
            if(!visited[edge[0]]){
                dfs(edge[0], dist + edge[1]);
            }
        }
    }
}