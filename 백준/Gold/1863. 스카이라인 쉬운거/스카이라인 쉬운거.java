import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek() > h) {
				stack.pop();
				ans++;
			}
			
			if(!stack.isEmpty() && stack.peek() == h) {
				continue;
			}
			
			if(h > 0) {
				stack.add(h);
			}
		}
		System.out.println(ans + stack.size());
	}
}