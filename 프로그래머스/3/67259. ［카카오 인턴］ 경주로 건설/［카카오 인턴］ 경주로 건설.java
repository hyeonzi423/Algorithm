import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int N = board[0].length;
        int[][][] cost = new int[N][N][4];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[3] - b[3])); // [x, y, d, c]
        pq.add(new int[]{0, 0, 1, 0});
        pq.add(new int[]{0, 0, 2, 0});
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int x = now[0], y = now[1], d = now[2], c = now[3];
            
            if(x == N-1 && y == N-1){
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
            
                if(0 > nx || nx >= N || 0 > ny || ny >= N || board[nx][ny] == 1) continue;
                
                int tmpC = (i == d) ? c + 100 : c + 600;
                
                if(cost[nx][ny][i] > tmpC){
                    pq.add(new int[]{nx, ny, i, tmpC});
                    cost[nx][ny][i] = tmpC;
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            ans = Math.min(ans, cost[N-1][N-1][i]);
        }
        return ans;
    }
}