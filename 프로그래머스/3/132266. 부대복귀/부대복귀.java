import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<Integer>[] edge = new ArrayList[n+1];
        int[] dis = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dis[i] = Integer.MAX_VALUE;
            edge[i] = new ArrayList<>();
        }
        
        for(int[] r : roads){
            edge[r[0]].add(r[1]);
            edge[r[1]].add(r[0]);
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(new int[]{destination, 0});
        visited[destination] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            dis[now[0]] = Math.min(dis[now[0]], now[1]);
            
            for(int next : edge[now[0]]){
                if(visited[next]) continue;
                q.add(new int[]{next, now[1] + 1});
                visited[next] = true;
            }
        }
        
        int[] ans = new int[sources.length];
        for(int i = 0; i < sources.length; i++){
            if(dis[sources[i]] == Integer.MAX_VALUE){
                ans[i] = -1;
            }else{
                ans[i] = dis[sources[i]];
            }
        }
        
        return ans;
    }
}