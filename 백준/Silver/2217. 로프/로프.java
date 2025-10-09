import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(br.readLine().trim());
        }
        
        Arrays.sort(w);
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long canLift = (long) w[i] * (n - i); // 최소하중 w[i] × 사용 로프 개수
            if (canLift > ans) ans = canLift;
        }
        System.out.println(ans);
    }
}