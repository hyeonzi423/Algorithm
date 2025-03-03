import java.util.*;
import java.io.*;

class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> graph;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(p).add(c);
            graph.get(c).add(p);
        }

        dp = new int[N + 1][2];  // 0 = 얼리어답터 X, 1 = 얼리어답터 O
        visited = new boolean[N + 1];

        DFS(1, -1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void DFS(int node, int parent) {
        dp[node][1] = 1; // 현재 노드를 얼리어답터로 선택
        dp[node][0] = 0; // 현재 노드를 얼리어답터로 선택하지 않음

        visited[node] = true;

        for (int child : graph.get(node)) {
            if (child == parent) continue;

            DFS(child, node);

            dp[node][0] += dp[child][1]; // 내가 얼리어답터가 아니면 자식은 반드시 얼리어답터여야 함
            dp[node][1] += Math.min(dp[child][0], dp[child][1]); // 내가 얼리어답터이면, 자식은 아무 상태나 가능
        }
    }
}