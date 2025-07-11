import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
         
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for(int i = 0; i < N; i++){
            pq.add(new int[]{Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken())});
        }
        
        long ans = 0;
        for(int i = 0; i < N; i++){
            int[] tree = pq.poll();
            ans += tree[0] + (long)tree[1] * i;
        }

        System.out.println(ans);
    }
}