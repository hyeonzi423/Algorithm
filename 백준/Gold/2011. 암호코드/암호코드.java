import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        int N = code.length();
        int[] dp = new int[N + 1];

        dp[0] = 1;
        if(code.charAt(0) == '0'){
            System.out.println(0);
            return;
        }

        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            int one = code.charAt(i - 1);
            int two = code.charAt(i - 2);

            if(one >= '1' && one <= '9'){
                dp[i] = (dp[i] + dp[i - 1]) % 1000000;
            }

            int twoDigit = (two - '0')*10 + (one - '0');
            if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;
            }
        }
        
        System.out.println(dp[N]);
    }
}