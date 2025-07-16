import java.util.*;
import java.io.*;

class Main {

    private static int N, sum, ans = 0;
    private static int[] number;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sum = Integer.parseInt(st.nextToken());

        number = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) number[i] = Integer.parseInt(st.nextToken());
        
        dfs(0, 0);

        if(sum == 0) ans--;
        System.out.println(ans);
    }

    public static void dfs(int index, int value){
        if(index == N){
            if(value == sum) ans++;
            return;
        }   

        dfs(index + 1, value);
        dfs(index + 1, value + number[index]);
    }
}