import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 맛 개수 (1..N)
        int M = Integer.parseInt(st.nextToken()); // 금지 쌍 개수

        boolean[][] bad = new boolean[N + 1][N + 1];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bad[a][b] = bad[b][a] = true;
        }

        int count = 0;
        for (int i = 1; i <= N - 2; i++) {
            for (int j = i + 1; j <= N - 1; j++) {
                if (bad[i][j]) continue; // i-j가 금지면 k 볼 필요 없음
                for (int k = j + 1; k <= N; k++) {
                    if (bad[i][k] || bad[j][k]) continue;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}