import java.util.*;
class Solution {
    public int solution(int N, int[][] edge) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e: edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int[] visited = new int[N+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 1});
        visited[1] = 1;
        int maxValue = -1;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int e : graph.get(now[0])){
                if(visited[e] == 0){
                    visited[e] = now[1] + 1;
                    maxValue = Math.max(maxValue, visited[e]);
                    q.add(new int[]{e, now[1] + 1});
                }
            }
        }
        
        int answer = 0;
        for(int v : visited){
            if(v == maxValue){
                answer++;
            }
        }
        return answer;
    }
}