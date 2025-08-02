import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        ArrayList<ArrayList<Integer>> connect = new ArrayList<>();
        for(int i = 0; i < n; i++){
            connect.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && computers[i][j] == 1){
                    connect.get(i).add(j);
                    connect.get(j).add(i);
                }
            }
        }
        
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;
                
                while(!q.isEmpty()){
                    int now = q.poll();
                    for(int c : connect.get(now)){
                        if(!visited[c]){
                            visited[c] = true;
                            q.add(c);
                        }
                    }
                }
            }
        }
        return answer;
    }
}