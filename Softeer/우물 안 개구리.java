import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] weight = new int[N+1];
        boolean[] best = new boolean[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            weight[i] = Integer.parseInt(st.nextToken());
            best[i] = true;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(weight[a] > weight[b]){
                best[b] = false;
            }else if(weight[a] == weight[b]){
                best[a] = false;
                best[b] = false;
            }else{
                best[a] = false;
            }
        }

        int ans = 0;
        for(int i = 1; i <= N; i++){
            if(best[i]){
                ans++;
            }
        }
        System.out.println(ans);
    }
}

