import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long N = 1;
        while(true){
            if(S - N <= 0) break;
            S -= N;
            N++;
        }
        System.out.println(S != N ? N-1 : N);
    }
}