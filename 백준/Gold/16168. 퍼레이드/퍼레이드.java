import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] degree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 수
        int E = Integer.parseInt(st.nextToken()); // 간선 수

        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        degree = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
            degree[a]++;
            degree[b]++;
        }

        // 간선이 연결된 아무 정점에서 DFS 시작
        int start = -1;
        for (int i = 1; i <= V; i++) {
            if (degree[i] > 0) {
                start = i;
                break;
            }
        }

        // 간선이 하나도 없는 경우 → YES
        if (start == -1) {
            System.out.println("YES");
            return;
        }

        // 연결 여부 확인
        dfs(start);

        for (int i = 1; i <= V; i++) {
            if (degree[i] > 0 && !visited[i]) {
                System.out.println("NO");
                return;
            }
        }

        // 홀수 차수 정점 개수 세기
        int odd = 0;
        for (int i = 1; i <= V; i++) {
            if (degree[i] % 2 != 0) {
                odd++;
            }
        }

        // 오일러 경로 또는 회로 조건
        if (odd == 0 || odd == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void dfs(int v) {
        visited[v] = true;
        for (int u : graph[v]) {
            if (!visited[u]) {
                dfs(u);
            }
        }
    }
}