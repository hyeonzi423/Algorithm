import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] numbers;       // 입력 숫자
    static int[] operators;     // 연산자 개수: [+,-,*,/]
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int result) {
        if (idx == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                int next = result;
                if (i == 0) next += numbers[idx];           // 덧셈
                else if (i == 1) next -= numbers[idx];      // 뺄셈
                else if (i == 2) next *= numbers[idx];      // 곱셈
                else if (i == 3) next /= numbers[idx];      // 나눗셈 (정수 나눗셈)

                dfs(idx + 1, next);
                operators[i]++;
            }
        }
    }
}
