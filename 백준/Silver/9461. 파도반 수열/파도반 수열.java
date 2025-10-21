import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] queries = new int[T];
        int maxN = 0;

        for (int i = 0; i < T; i++) {
            queries[i] = Integer.parseInt(br.readLine());
            if (queries[i] > maxN) maxN = queries[i];
        }

        // 문제에서 n ≤ 100
        int N = Math.max(6, maxN);      // 최소 인덱스 안전 확보
        long[] P = new long[N + 1];

        // 초기값
        P[1] = 1L; P[2] = 1L; P[3] = 1L; P[4] = 2L; P[5] = 2L;

        for (int i = 6; i <= N; i++) {
            P[i] = P[i - 1] + P[i - 5];
        }

        for (int q : queries) {
            sb.append(P[q]).append('\n');
        }

        System.out.print(sb.toString());
    }
}