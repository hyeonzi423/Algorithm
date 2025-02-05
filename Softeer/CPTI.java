import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[0]);

        int[] cbti = new int[N];
        for(int i = 0; i < N; i++){
            cbti[i] = Integer.parseInt(br.readLine(), 2);
        }

        int ans = 0;
        for(int i = 0; i < N-1; i++){
            for(int j = i+1; j < N; j++){
                int cnt = Integer.bitCount(cbti[i]^cbti[j]);
                if(cnt <= 2){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
