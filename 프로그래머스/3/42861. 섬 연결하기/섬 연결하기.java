import java.util.*;
class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, ((o1, o2) -> (o1[2] - o2[2])));
        
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        int answer = 0;
        for(int[] c : costs){
            if(find(c[0]) != find(c[1])){
                union(c[0], c[1]);
                answer += c[2];
            }
        }
        return answer;
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            return find(parent[x]);
        }
    }
    
    public void union(int x, int y){
        int a = find(x);
        int b = find(y);
        
        if(a > b){
            parent[a] = b;
        }else{
            parent[b] = a;
        }
    }
}