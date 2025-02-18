import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        System.out.println(count(end) - count(start - 1));
    }

    static long count(long n) {
        if (n == 0) return 0;

        long count = 0;
        long powerOfTwo = 1;

        while (powerOfTwo <= n) {
            long totalPairs = (n + 1) / (powerOfTwo * 2);
            long remainder = (n + 1) % (powerOfTwo * 2);

            count += totalPairs * powerOfTwo;
            count += Math.max(0, remainder - powerOfTwo);

            powerOfTwo *= 2;
        }

        return count;
    }
}