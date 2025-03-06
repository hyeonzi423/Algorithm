import java.util.*;
import java.io.*;

class Main {

    static int N, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;
        int islandId = 2; 

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    labelIsland(i, j, islandId++);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 1) {
                    checkBridge(i, j, map[i][j]);
                }
            }
        }

        System.out.println(ans);
    }

    public static void labelIsland(int x, int y, int islandId) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = islandId;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                map[nx][ny] = islandId;
                q.add(new int[]{nx, ny});
            }
        }
    }

    public static void checkBridge(int x, int y, int islandId) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] tmpVisited = new boolean[N][N];

        q.add(new int[]{x, y, 0});
        tmpVisited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int dist = now[2];

            if (dist >= ans) return;

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (tmpVisited[nx][ny]) continue;

                if (map[nx][ny] > 1 && map[nx][ny] != islandId) {
                    ans = Math.min(ans, dist);
                    return;
                }

                if (map[nx][ny] == 0) {
                    tmpVisited[nx][ny] = true;
                    q.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
    }
}
