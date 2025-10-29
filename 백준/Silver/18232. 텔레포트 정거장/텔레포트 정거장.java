import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 텔레포트 간선 인접 리스트
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // BFS
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();

        dist[S] = 0;
        q.offer(S);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == E) break;

            // 1) cur - 1
            if (cur - 1 >= 1 && dist[cur - 1] == -1) {
                dist[cur - 1] = dist[cur] + 1;
                q.offer(cur - 1);
            }
            // 2) cur + 1
            if (cur + 1 <= N && dist[cur + 1] == -1) {
                dist[cur + 1] = dist[cur] + 1;
                q.offer(cur + 1);
            }
            // 3) 텔레포트 이웃들
            for (int nxt : graph[cur]) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    q.offer(nxt);
                }
            }
        }

        System.out.println(dist[E]);
    }
}