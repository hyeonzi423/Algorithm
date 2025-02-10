import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long ans = 0L;
            while (pq.size() > 1) {
                long n1 = pq.poll();
                long n2 = pq.poll();

                long sum = n1 + n2;
                ans += sum;
                pq.add(sum);
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}