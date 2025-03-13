import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int computer, time;
        Node(int computer, int time) {
            this.computer = computer;
            this.time = time;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

            List<List<Node>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                adj.get(b).add(new Node(a, s));
            }

            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(c, 0));
            dist[c] = 0;

            int count = 0, maxTime = 0;

            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                int curComp = cur.computer;
                int curTime = cur.time;

                if (curTime > dist[curComp]) continue;

                count++;
                maxTime = Math.max(maxTime, curTime);

                for (Node next : adj.get(curComp)) {
                    if (dist[next.computer] > curTime + next.time) {
                        dist[next.computer] = curTime + next.time;
                        pq.add(new Node(next.computer, dist[next.computer]));
                    }
                }
            }

            sb.append(count).append(" ").append(maxTime).append("\n");
        }
        System.out.print(sb);
    }
}