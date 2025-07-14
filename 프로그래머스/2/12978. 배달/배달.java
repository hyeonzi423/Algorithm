import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for(int[] r : road){
            graph[r[0]].add(new int[]{r[1], r[2]});
            graph[r[1]].add(new int[]{r[0], r[2]});
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[]{1, 0});
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int node = now[0], cost = now[1];
            
            if(cost > dist[node]) continue;
            
            for (int[] next : graph[node]) {
                int nextNode = next[0], nextCost = next[1];
                if (dist[nextNode] > dist[node] + nextCost) {
                    dist[nextNode] = dist[node] + nextCost;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        
        int answer = 0;
        for(int d : dist){
            if(d <= K) answer++;
        }
        return answer;
    }
}