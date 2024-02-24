import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static int map[][], paper[], ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		paper = new int[5];
		Arrays.fill(paper, 5);
		
		ans = Integer.MAX_VALUE;
		dfs(0, 0, 0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	public static void dfs(int x, int y, int cnt) { // cnt : 현재까지 사용한 색종이 수
		if(x >= 9 && y > 9) {
			ans = Math.min(ans, cnt);
		}
		if(ans <= cnt) {
			return;
		}
		if (y > 9) {
			dfs(x+1, 0, cnt);
			return;
		}
		if(map[x][y] == 1) {
			for(int i = 5; i >0; i--) {
				if(paper[i-1] > 0 && isPossible(x, y, i)) {
					change(x, y, i, 0);
					paper[i-1] -= 1;
					dfs(x, y+1, cnt+1);
					change(x, y, i, 1);
					paper[i-1] += 1;
				}
			}
		}else {
			dfs(x, y+1, cnt);
		}
	}

	public static boolean isRange(int x, int y) {
		return 0 <= x && x < 10 && 0 <= y && y < 10;
	}

	public static boolean isPossible(int x, int y, int s) {
		for (int i = x; i < x + s; i++) {
			for (int j = y; j < y + s; j++) {
				if (!isRange(i, j)) {
					return false;
				}
				if (map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void change(int x, int y, int s, int c) {
		for (int i = x; i < x + s; i++) {
			for (int j = y; j < y + s; j++) {
				map[i][j] = c;
			}
		}
	}

}