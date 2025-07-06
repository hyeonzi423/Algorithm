import java.util.*;
import java.io.*;

class Main {
    static int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[MAX + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        visited[N] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int pos = now[0];
            int count = now[1];

            if (pos == M) {
                System.out.println(count);
                return;
            }

            int[] nextPositions = {
                pos - 1, pos + 1,
                pos - A, pos + A,
                pos - B, pos + B,
                pos * A, pos * B
            };

            for (int next : nextPositions) {
                if (next >= 0 && next <= MAX && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, count + 1});
                }
            }
        }
    }
}