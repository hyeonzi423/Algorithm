import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];                 
        });
        for(int i = 0; i < N; i++){
            int now = Integer.parseInt(br.readLine());
            if(now == 0){
                if(pq.size() == 0) {
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()[1]).append("\n");
                }
            }else{
                pq.add(new int[]{Math.abs(now), now});
            }
        }

        System.out.println(sb);
    }
}