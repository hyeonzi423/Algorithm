import java.io.*;
import java.util.*;

public class Main {

    static class Pattern {
        String w;
        int score;
        Pattern(String w, int score) {
            this.w = w;
            this.score = score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int n = S.length();

        int M = Integer.parseInt(br.readLine().trim());
        List<Pattern> patterns = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String w = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            patterns.add(new Pattern(w, p));
        }

        List<Pattern> useful = new ArrayList<>();
        for (Pattern pat : patterns) {
            if (pat.score > pat.w.length()) useful.add(pat);
        }
        if (!useful.isEmpty()) patterns = useful;

        int[] dp = new int[n + 1]; // dp[n] = 0 (기저)

        for (int i = n - 1; i >= 0; i--) {
            // 1) 문자 1개 그냥 지우기
            dp[i] = dp[i + 1] + 1;

            // 2) 등록된 패턴이 i에서 시작하면 사용
            for (Pattern pat : patterns) {
                int len = pat.w.length();
                if (i + len <= n && S.startsWith(pat.w, i)) {
                    dp[i] = Math.max(dp[i], pat.score + dp[i + len]);
                }
            }
        }

        System.out.println(dp[0]);
    }
}