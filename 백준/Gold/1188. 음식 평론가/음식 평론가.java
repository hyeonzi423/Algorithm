import java.util.*;
import java.io.*;

public class Main {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 평론가 수
        int M = Integer.parseInt(st.nextToken()); // 조각 수

        int answer = M - gcd(N, M);
        System.out.println(answer);
    }
}

