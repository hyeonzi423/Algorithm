import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            int left = 0, right = n - 1;
            int best = Integer.MAX_VALUE; // K와의 최소 차이
            int cnt = 0;                  // 최소 차이를 만드는 쌍의 개수

            while (left < right) {
                int sum = arr[left] + arr[right];
                int diff = Math.abs(sum - K);

                if (diff < best) {
                    best = diff;
                    cnt = 1;
                } else if (diff == best) {
                    cnt++;
                }

                if (sum > K) right--;
                else left++;
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb.toString());
    }
}