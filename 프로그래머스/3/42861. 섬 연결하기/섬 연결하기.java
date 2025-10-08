import java.util.*;

class Solution {
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[2] - b[2]));
        
        parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        
        int answer = 0;
        for(int[] c: costs){
            if(find(c[0]) != find(c[1])){
                union(c[0], c[1]);
                answer += c[2];
            }
        }
        
        return answer;
    }
    
    public int find(int x){
        if(parents[x] == x){
            return x;
        }
        return find(parents[x]);
    }
    
    public void union(int x, int y){
        int a = find(x);
        int b = find(y);
        
        if(a > b){
            parents[a] = b;
        }else{
            parents[b] = a;
        }
    }
}