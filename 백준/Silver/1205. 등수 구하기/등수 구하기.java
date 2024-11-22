import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Long T = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int front = 0, rank = 0;

        if(N != 0){ 
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                Long tmp = Long.parseLong(st.nextToken());
                if(tmp >= T){
                    front++;
                }if(tmp > T){
                    rank++;
                }
            }
        }
        if(N == 0){
            System.out.println(1);   
        }else{
            System.out.println(front >= P ? -1 : rank + 1);   
        }
    }
}