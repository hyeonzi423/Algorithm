class Solution {
    public int solution(int n, int m, int[][] puddles) {
        int per = 1000000007;
        int[][] dp = new int[n+1][m+1];
        
        for(int[] tmp : puddles){
            dp[tmp[0]][tmp[1]] = -1; 
        }
        
        dp[1][1] = 1;
        for(int i = 1 ; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(dp[i][j] == -1) continue;
                if(dp[i-1][j] > 0) dp[i][j] += dp[i-1][j] % per;
                if(dp[i][j-1] > 0) dp[i][j] += dp[i][j-1] % per;
            }
        }
        return dp[n][m] % per;
    }
}