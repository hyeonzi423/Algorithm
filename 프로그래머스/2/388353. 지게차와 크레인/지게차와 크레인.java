import java.util.*;

public class Solution {
    static int N, M;
    static char[][] map;
    static int answer;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        map = new char[N][M];
        answer = N * M;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = storage[i].charAt(j);
            }
        }

        for (String req : requests) {
            char target = req.charAt(0);
            if (req.length() == 2) {
                crane(target);
            } else {
                forklift(target);
            }
        }

        return answer;
    }

    static void crane(char target) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == target) {
                    map[i][j] = '0';
                    answer--;
                }
            }
        }
    }

    static void forklift(char target) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        List<int[]> toRemove = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isEdge(i, j) && (map[i][j] == '0' || map[i][j] == target)){
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (map[x][y] == target) {
                toRemove.add(new int[]{x, y});
            }

            if (map[x][y] == '0') { 
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]
                       && (map[nx][ny] == '0' || map[nx][ny] == target)) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        for (int[] rem : toRemove) {
            int x = rem[0], y = rem[1];
            map[x][y] = '0';
            answer--;
        }
    }

    static boolean isEdge(int x, int y) {
        return x == 0 || x == N - 1 || y == 0 || y == M - 1;
    }
}
