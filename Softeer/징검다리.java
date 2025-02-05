import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stone = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            stone[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(stone[i] > stone[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}

