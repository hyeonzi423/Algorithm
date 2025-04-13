import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lines = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int result = 0;
        int start = lines[0][0];
        int end = lines[0][1];

        for (int i = 1; i < N; i++) {
            if (lines[i][0] <= end) {
                end = Math.max(end, lines[i][1]);
            } else {
                result += end - start;
                start = lines[i][0];
                end = lines[i][1];
            }
        }

        result += end - start;
        System.out.println(result);
    }
}