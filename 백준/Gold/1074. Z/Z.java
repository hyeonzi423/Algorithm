import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int ans = 0, x = 0, y = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		find(r, c, (int) Math.pow(2, N));
	}

	public static void find(int r, int c, int size) {
		size /= 2;
		if (size < 1) {
			System.out.println(ans);
			return;
		}
		if (r < x + size && c < y + size) {
			ans += size * size * 0;
		} else if (r < x + size && c >= y + size) {
			ans += size * size * 1;
			y += size;
		} else if (r >= x + size && c < y + size) {
			ans += size * size * 2;
			x += size;
		} else {
			ans += size * size * 3;
			x += size;
			y += size;
		}
		find(r, c, size);
	}

}