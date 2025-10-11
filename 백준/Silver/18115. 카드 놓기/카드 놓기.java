import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ops = new int[n];
        for (int i = 0; i < n; i++) ops[i] = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = n - 1, card = 1; i >= 0; i--, card++) {
            int op = ops[i];
            if (op == 1) {
                dq.addFirst(card);
            } else if (op == 2) {
                Integer first = dq.isEmpty() ? null : dq.pollFirst();
                dq.addFirst(card);
                if (first != null) dq.addFirst(first);
            } else {
                dq.addLast(card);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) sb.append(dq.pollFirst()).append(' ');
        System.out.print(sb.toString().trim());
    }
}