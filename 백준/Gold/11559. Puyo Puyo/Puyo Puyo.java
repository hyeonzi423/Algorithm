import java.io.*;
import java.util.*;

public class Main {
    static final int N = 12, M = 6;              
    static char[][] board = new char[N][M];
    static final int[] dx = {-1, 1, 0, 0};     
    static final int[] dy = {0, 0, -1, 1};      

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int x = 0; x < N; x++) {
            String line = br.readLine();
            for (int y = 0; y < M; y++) board[x][y] = line.charAt(y);
        }

        int chain = 0;
        while (true) {
            boolean poppedThisRound = false;
            boolean[][] visited = new boolean[N][M];
            boolean[][] toPop = new boolean[N][M];

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    char color = board[x][y];
                    if (color == '.' || visited[x][y]) continue;

                    // BFS로 같은 색 묶음 찾기
                    Queue<int[]> q = new ArrayDeque<>();
                    List<int[]> comp = new ArrayList<>();
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                    comp.add(new int[]{x, y});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k], ny = cur[1] + dy[k];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            if (visited[nx][ny] || board[nx][ny] != color) continue;
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                            comp.add(new int[]{nx, ny});
                        }
                    }

                    if (comp.size() >= 4) {
                        poppedThisRound = true;
                        for (int[] p : comp) toPop[p[0]][p[1]] = true;
                    }
                }
            }

            if (!poppedThisRound) break;

            // 동시에 터뜨리기
            for (int x = 0; x < N; x++)
                for (int y = 0; y < M; y++)
                    if (toPop[x][y]) board[x][y] = '.';

            // 중력 적용
            applyGravity();

            chain++;
        }

        System.out.println(chain);
    }

    static void applyGravity() {
        for (int y = 0; y < M; y++) {
            int write = N - 1;
            for (int x = N - 1; x >= 0; x--) {
                if (board[x][y] != '.') {
                    char v = board[x][y];
                    board[x][y] = '.';
                    board[write][y] = v;
                    write--;
                }
            }
        }
    }
}