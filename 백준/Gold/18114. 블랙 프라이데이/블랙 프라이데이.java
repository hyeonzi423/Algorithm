import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long[] weight = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(weight);

        for (int i = 0; i < N; i++) {
            if (weight[i] == C) {
                System.out.println(1);
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (weight[i] + weight[j] == C) {
                    System.out.println(1);
                    return;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                long need = C - (weight[i] + weight[j]);
                if (need <= 0) continue;
                int idx = Arrays.binarySearch(weight, need);
                // idx가 i, j와 다르고, 존재해야 함
                if (idx >= 0 && idx != i && idx != j) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
