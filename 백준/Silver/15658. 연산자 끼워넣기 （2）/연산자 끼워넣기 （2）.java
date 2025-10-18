import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static int[] ops = new int[4]; // +, -, *, /
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    static void dfs(int idx, int val) {
        if (idx == N) {
            if (val > max) max = val;
            if (val < min) min = val;
            return;
        }
        int next = A[idx];

        if (ops[0] > 0) { // +
            ops[0]--;
            dfs(idx + 1, val + next);
            ops[0]++;
        }
        if (ops[1] > 0) { // -
            ops[1]--;
            dfs(idx + 1, val - next);
            ops[1]++;
        }
        if (ops[2] > 0) { // *
            ops[2]--;
            dfs(idx + 1, val * next);
            ops[2]++;
        }
        if (ops[3] > 0) { // /
            ops[3]--;
            dfs(idx + 1, val / next); // 자바 int 나눗셈: 0을 향해 버림
            ops[3]++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) ops[i] = Integer.parseInt(st.nextToken());

        dfs(1, A[0]);

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n').append(min);
        System.out.print(sb.toString());
    }
}