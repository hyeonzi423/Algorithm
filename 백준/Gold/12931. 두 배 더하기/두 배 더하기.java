import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());

        long ops = 0;
        while (true) {
            boolean allZero = true;

            // 1) 홀수들을 1씩 빼기
            for (int i = 0; i < n; i++) {
                if ((a[i] & 1L) == 1L) {
                    a[i]--;
                    ops++;
                }
                if (a[i] != 0) allZero = false;
            }
            if (allZero) break;

            // 2) 모두 짝수라면 전부 2로 나누기
            for (int i = 0; i < n; i++) a[i] >>= 1;
            ops++;
        }

        System.out.println(ops);
    }
}
