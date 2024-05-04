import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int start = Integer.MAX_VALUE;
		int end = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			arr[L] = H;
			start = Math.min(L, start);
			end = Math.max(L, end);
		}

		Stack<Integer> stack = new Stack<>();
		int temp = arr[start];
		for (int i = start + 1; i <= end; i++) {
			if (arr[i] < temp) {
				stack.push(i);
			} else {
				while (!stack.isEmpty()) {
					int x = stack.pop();
					arr[x] = temp;
				}
				temp = arr[i];
			}
		}
		stack.clear();

		temp = arr[end];
		for (int i = end - 1; i >= start; i--) {
			if (arr[i] < temp)
				stack.push(i);
			else {
				while (!stack.isEmpty()) {
					int x = stack.pop();
					arr[x] = temp;
				}
				temp = arr[i];
			}
		}

		int ans = 0;
		for (int i = start; i <= end; i++) {
			ans += arr[i];
		}

		System.out.print(ans);
	}
}