import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] height = new int[N + 1];
        int[] count = new int[N + 1];
        int[] closest = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            closest[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();

        // 왼쪽 → 오른쪽
        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }
            count[i] = stack.size();
            if (count[i] > 0) {
                closest[i] = stack.peek();
            }
            stack.push(i);
        }

        stack = new Stack<>();

        // 오른쪽 → 왼쪽
        for (int i = N; i > 0; i--) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }
            int s = stack.size();
            count[i] += s;
            if (s > 0) {
                if (closest[i] == -1 || (stack.peek() - i < i - closest[i])) {
                    closest[i] = stack.peek();
                }
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(count[i]);
            if (count[i] > 0) {
                sb.append(" ").append(closest[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}