import java.util.*;
import java.io.*;

class Main {
    static Set<String> visited = new HashSet<>();
    static int total;
    
    public static void main(String[] args) throws Exception {
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

        System.out.println(bfs(a, b, c) ? 1 : 0);
    }

    static boolean bfs(int a, int b, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b, c});
        visited.add(a + "," + b + "," + c);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], z = cur[2];

            if (x == y && y == z) return true;

            int[][] moves = {{x, y}, {x, z}, {y, z}};
            for (int[] m : moves) {
                int min = Math.min(m[0], m[1]);
                int max = Math.max(m[0], m[1]);

                int nx = min * 2;
                int ny = max - min;
                int nz = total - (nx + ny);

                int[] sorted = {nx, ny, nz};
                Arrays.sort(sorted);
                String state = sorted[0] + "," + sorted[1] + "," + sorted[2];

                if (!visited.contains(state)) {
                    visited.add(state);
                    q.offer(new int[]{sorted[0], sorted[1], sorted[2]});
                }
            }
        }
        return false;
    }
}