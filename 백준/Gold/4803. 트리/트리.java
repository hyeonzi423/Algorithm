import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] g;
    static boolean[] visited;
    static boolean hasCycle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int tc = 1;

        while (true) {
            String line;
            do { line = br.readLine(); } while (line != null && line.trim().isEmpty());
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            g = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                g[a].add(b);
                g[b].add(a);
            }

            visited = new boolean[n + 1];
            int treeCount = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    hasCycle = false;
                    dfs(i, 0);
                    if (!hasCycle) treeCount++;
                }
            }

            if (treeCount == 0) {
                out.append("Case ").append(tc++).append(": No trees.\n");
            } else if (treeCount == 1) {
                out.append("Case ").append(tc++).append(": There is one tree.\n");
            } else {
                out.append("Case ").append(tc++).append(": A forest of ")
                   .append(treeCount).append(" trees.\n");
            }
        }

        System.out.print(out.toString());
    }

    static void dfs(int cur, int parent) {
        visited[cur] = true;
        for (int nxt : g[cur]) {
            if (!visited[nxt]) {
                dfs(nxt, cur);
            } else if (nxt != parent) {
                hasCycle = true;
            }
        }
    }
}