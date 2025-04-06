import java.util.*;
import java.io.*;

public class Main {
    static int N, M, maxStrength = 0;
    static int[][] wood;
    static boolean[][] visited;

    static int[][][] boShapes = {
        {{0, 0}, {0, -1}, {1, 0}}, // 'ㄱ' 모양
        {{0, 0}, {0, 1}, {1, 0}},  // 'ㄴ' 모양
        {{0, 0}, {-1, 0}, {0, -1}},// 'ㄴ' 좌우 반전 모양
        {{0, 0}, {-1, 0}, {0, 1}}  // 'ㄱ' 좌우 반전 모양
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wood = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                wood[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        System.out.println(maxStrength);
    }

    public static void dfs(int x, int y, int currentStrength) {
        if (x == N) {
            maxStrength = Math.max(maxStrength, currentStrength);
            return;
        }

        int nextX = (y == M - 1) ? x + 1 : x;
        int nextY = (y == M - 1) ? 0 : y + 1;

        if (!visited[x][y]) {
            for (int[][] shape : boShapes) {
                int sum = 0;
                boolean canPlace = true;
                List<int[]> positions = new ArrayList<>();

                for (int i = 0; i < shape.length; i++) {
                    int[] s = shape[i];
                    int nx = x + s[0];
                    int ny = y + s[1];
                
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                        canPlace = false;
                        break;
                    }
                
                    if (i == 0) sum += wood[nx][ny] * 2;
                    else sum += wood[nx][ny];
                
                    positions.add(new int[]{nx, ny});
                }

                if (canPlace) {
                    for (int[] pos : positions) {
                        visited[pos[0]][pos[1]] = true;
                    }

                    dfs(nextX, nextY, currentStrength + sum);

                    for (int[] pos : positions) {
                        visited[pos[0]][pos[1]] = false;
                    }
                }
            }
        }

        dfs(nextX, nextY, currentStrength);
    }
}