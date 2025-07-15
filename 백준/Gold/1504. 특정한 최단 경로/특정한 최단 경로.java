import java.util.*;
import java.io.*;

public class Main {
    static int N, E;
    static final int INF = 200000000;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] distFrom1 = dijkstra(1);
        int[] distFromV1 = dijkstra(v1);
        int[] distFromV2 = dijkstra(v2);

        long route1 = (long)distFrom1[v1] + distFromV1[v2] + distFromV2[N];
        long route2 = (long)distFrom1[v2] + distFromV2[v1] + distFromV1[N];

        long result = Math.min(route1, route2);
        System.out.println(result >= INF ? -1 : result);
    }

    public static int[] dijkstra(int start){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int node = now[0];
            int cost = now[1];

            if(dist[node] < cost) continue;

            for(int[] next : graph[node]){
                int nextNode = next[0];
                int nextCost = next[1];
                if(dist[nextNode] > cost + nextCost){
                    dist[nextNode] = cost + nextCost;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        return dist;
    }
}