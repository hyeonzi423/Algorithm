import java.util.*;
class Solution {
    public static ArrayList<Integer>[] graph;
    public static int N;
    
    public int solution(int n, int[][] wires) {
        N = n + 1;
        graph = new ArrayList[N];
        for(int i = 1; i < N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] w : wires){
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }
        
        int answer = Integer.MAX_VALUE;
        for(int[] w : wires){
            graph[w[0]].remove(Integer.valueOf(w[1]));
            graph[w[1]].remove(Integer.valueOf(w[0]));
            
            answer = Math.min(answer, Math.abs(bfs(w[0]) - bfs(w[1])));
                              
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }
        return answer;
    }
    
    public int bfs(int start){
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        
        int cnt = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : graph[now]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}