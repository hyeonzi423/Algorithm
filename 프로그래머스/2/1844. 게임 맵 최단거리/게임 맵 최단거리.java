import java.util.*;
class Solution {
    static class Point{
        int x, y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
    }
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        int N = maps.length;
        int M = maps[0].length;
        int[][] visited = new int[N][M];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visited[0][0] = 1;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x == N-1 && now.y == M-1) break;
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(0 > nx || nx >= N || 0 > ny || ny >= M){
                    continue;
                }
                if(visited[nx][ny] != 0) continue;
                if(maps[nx][ny] != 1) continue;
                q.add(new Point(nx, ny));
                visited[nx][ny] = visited[now.x][now.y] + 1;
            }
        }
        return visited[N-1][M-1] != 0 ? visited[N-1][M-1] : -1;
    }
}