import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }   
        for(int[] e : edge){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        int[] visited = new int[n+1];
        int max = 0;
        visited[1] = 1;
        
        Queue<int[]> q = new LinkedList<>();
        for(int g : graph[1]){
            q.add(new int[]{g, 1});
            visited[g] = 1;
        }
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int g : graph[now[0]]){
                if(visited[g] == 0){
                    q.add(new int[]{g, now[1]+1});
                    visited[g] = now[1]+1;
                    max = Math.max(max, now[1]+1);
                }
            }
        }
        
        int ans = 0;
        for(int v : visited){
            if(max == v){
                ans++;
            }
        }
        return ans;
    }
}