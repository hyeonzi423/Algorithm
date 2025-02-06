import java.io.*;
import java.util.*;

public class Main {

    static int N, M, start, end;
    static ArrayList<Integer>[] graph, reverseGraph;
    static boolean[] fromStart, fromEnd, toStart, toEnd;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        reverseGraph = new ArrayList[N+1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            reverseGraph[e].add(s);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        fromStart = new boolean[N+1];
        fromEnd = new boolean[N+1];
        toStart = new boolean[N+1];
        toEnd = new boolean[N+1];

        fromStart[end] = true;
        fromEnd[start] = true;

        dfs(start, fromStart, graph);
        dfs(end, fromEnd, graph);
        dfs(start, toStart, reverseGraph);
        dfs(end, toEnd, reverseGraph);

        int ans = 0;
        for(int i = 1; i <= N; i++){
            if(fromStart[i] && fromEnd[i] && toStart[i] && toEnd[i]){
                ans++;
            }
        }
        System.out.println(ans-2);
    }

    public static void dfs(int node, boolean[] visited, ArrayList<Integer>[] graph){
        if(visited[node]){
            return;
        }
        visited[node] = true;
        for(int n : graph[node]){
            dfs(n, visited, graph);
        }
    }
}

