import java.io.*;
import java.util.*;

public class Main {

    static int N, L, R;
    static int[][] population;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        population = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean isMoved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            isMoved = true;
                        }
                    }
                }
            }

            if (!isMoved) {
                break;
            }
            ans++;
        }

        System.out.println(ans);
    }

    static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        q.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        int total = population[x][y];

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int curX = now[0], curY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }

                int gap = Math.abs(population[curX][curY] - population[nx][ny]);
                if (gap >= L && gap <= R) {
                    q.add(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    total += population[nx][ny];
                }
            }
        }

        if (union.size() > 1) {
            int newPop = total / union.size();
            for (int[] pos : union) {
                population[pos[0]][pos[1]] = newPop;
            }
            return true;
        }
        return false;
    }
}
