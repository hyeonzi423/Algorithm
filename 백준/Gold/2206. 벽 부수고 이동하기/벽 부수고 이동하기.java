import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visitedWithoutBreak = new boolean[N][M];
        boolean[][] visitedWithBreak = new boolean[N][M];

        q.add(new int[] { 0, 0, 0, 1 }); // x, y, 벽 부쉈는지 여부, 거리
        visitedWithoutBreak[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == N - 1 && now[1] == M - 1) {
                System.out.println(now[3]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                // 벽을 부수지 않고 이동하는 경우
                if (map[nx][ny] == 0) {
                    if (now[2] == 0 && !visitedWithoutBreak[nx][ny]) {
                        visitedWithoutBreak[nx][ny] = true;
                        q.add(new int[] { nx, ny, 0, now[3] + 1 });
                    } else if (now[2] == 1 && !visitedWithBreak[nx][ny]) {
                        visitedWithBreak[nx][ny] = true;
                        q.add(new int[] { nx, ny, 1, now[3] + 1 });
                    }
                }

                // 벽을 부수고 이동하는 경우
                if (map[nx][ny] == 1 && now[2] == 0 && !visitedWithBreak[nx][ny]) {
                    visitedWithBreak[nx][ny] = true;
                    q.add(new int[] { nx, ny, 1, now[3] + 1 });
                }
            }
        }
        System.out.println(-1);
    }
}