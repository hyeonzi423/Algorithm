import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            K = (K * P) % 1000000007;
        }
        System.out.println(K);
    }
}

