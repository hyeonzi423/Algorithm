class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n+1][n+1];
        for(int[] r : results){
            graph[r[0]][r[1]]= 1;
            graph[r[1]][r[0]]= -1;
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                    if(graph[i][k] == -1 && graph[k][j] == -1){
                        graph[i][j] = -1;
                    }
                }
            }
        }
        
        int ans = 0;
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(graph[i][j] != 0) cnt++;
            }
            if(cnt == n-1) ans++;
        }
        return ans;
    }
}