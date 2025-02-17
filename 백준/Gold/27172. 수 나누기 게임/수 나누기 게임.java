import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_N = 1000001;
    static int[] cnt = new int[MAX_N];
    static int[] score = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }

        for (int num = 1; num < MAX_N; num++) {
            if (cnt[num] > 0) {
                for (int mul = num * 2; mul < MAX_N; mul += num) {
                    if (cnt[mul] > 0) {
                        score[num] += cnt[mul];
                        score[mul] -= cnt[num];
                    }
                }
            }
        }

        for (int num : arr) {
            sb.append(score[num]).append(" ");
        }
        System.out.println(sb);
    }
}