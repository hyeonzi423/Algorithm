import java.util.*;
import java.awt.Point;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        int M = land[0].length;
        int[] count = new int[M];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    Queue<Point> q = new LinkedList<>();
                    Set<Integer> set = new HashSet<>();
                    set.add(j);
                    int tmpCnt = 1;
                    q.add(new Point(i, j));
                    
                    while (!q.isEmpty()) {
                        Point now = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = now.x + dx[k];
                            int ny = now.y + dy[k];
                            if (0 > nx || nx >= N || 0 > ny || ny >= M) {
                                continue;
                            }
                            if (visited[nx][ny] || land[nx][ny] == 0) {
                                continue;
                            }
                            set.add(ny);
                            tmpCnt++;
                            visited[nx][ny] = true;
                            q.add(new Point(nx, ny));
                        }
                    }
                    for (int s : set) {
                        count[s] += tmpCnt;
                    }
                }
            }
        }
        
        for (int c : count) {
            answer = Math.max(answer, c);
        }
        return answer;
    }
}
