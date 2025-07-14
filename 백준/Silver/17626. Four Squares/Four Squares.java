import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        ArrayList<Integer> squares = new ArrayList<>();
        for(int i = 1; i * i <= N; i++){
            squares.add(i*i);
        }
        
        dp[0] = 0;
        for(int i = 1; i <= N; i++){
            for(int s : squares){
                if(i < s) break;
                dp[i] = Math.min(dp[i], dp[i - s] + 1);
            }
        }
        
        System.out.println(dp[N]);
    }
}
