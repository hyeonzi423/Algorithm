import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] front = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			front[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<Integer> result = new ArrayList<>();

		for (int i = N; i >= 1; i--) {
			result.add(front[i - 1], i);
		}

		StringBuilder sb = new StringBuilder();
		for (int num : result) {
			sb.append(num).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}