import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 사람 수
        int[] L = new int[N]; // 체력 소모
        int[] J = new int[N]; // 기쁨
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101];

        for (int i = 0; i < N; i++) {
            for (int j = 100; j >= L[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - L[i]] + J[i]);
            }
        }

        int maxJoy = 0;
        for (int i = 1; i < 100; i++) {
            maxJoy = Math.max(maxJoy, dp[i]);
        }

        System.out.println(maxJoy);
    }
}
