import java.io.*;
import java.util.*;

public class Main {
    public static boolean[][] visited;
    public static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        total = a + b + c;

        if (total % 3 != 0) {
            System.out.println(0);
            return;
        }

        visited = new boolean[total + 1][total + 1];
        System.out.println(bfs(a, b, c) ? 1 : 0);
    }

    public static boolean bfs(int a, int b, int c) {
        Queue<int[]> q = new LinkedList<>();
        int[] start = {a, b, c};
        Arrays.sort(start);

        q.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], z = total - (x + y);

            if (x == y && y == z) return true;

            int[][] moves = {{x, y}, {x, z}, {y, z}};

            for (int[] m : moves) {
                if (m[0] != m[1]) {
                    int min = Math.min(m[0], m[1]);
                    int max = Math.max(m[0], m[1]);

                    int nx = min * 2;
                    int ny = max - min;
                    int nz = total - (nx + ny);

                    int[] sorted = {nx, ny, nz};
                    Arrays.sort(sorted);

                    if (!visited[sorted[0]][sorted[1]]) {
                        visited[sorted[0]][sorted[1]] = true;
                        q.offer(new int[]{sorted[0], sorted[1]});
                    }
                }
            }
        }
        return false;
    }
}