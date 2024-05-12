import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		if (N == 0) {
			System.out.println(1);
			System.exit(0);

		}
		
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[] list = new int[N];
		int rank = 1;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		if (N == P && score <= list[list.length - 1])
			System.out.println(-1);
		
		else {
			for (int i = 0; i < list.length; i++) {
				if (score < list[i])
					rank++;
				else
					break;
			}
			System.out.println(rank);
		}

	}
}