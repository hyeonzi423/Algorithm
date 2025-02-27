import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] children = new int[N];
        for(int i = 0; i < N; i++){
            children[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(children[j] < children[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++){
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(N - max);
    }
}