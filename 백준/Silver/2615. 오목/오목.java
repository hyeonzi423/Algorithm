import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[21][21];
	static int[][][] memo = new int[21][21][4];
	static int[] dx = { 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i <= 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(find());
	}

	private static String find() {
		for (int j = 1; j <= 19; j++) {
			for (int i = 1; i <= 19; i++) {
				if (map[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						if (memo[i][j][d] == 0 && calc(i, j, d, map[i][j]) == 5) {
							return map[i][j] + "\n" + i + " " + j + "\n";
						}
					}
				}
			}
		}
		return "0";
	}

	private static int calc(int x, int y, int dir, int color) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (map[nx][ny] == color) {
			return memo[nx][ny][dir] = calc(nx, ny, dir, color) + 1;
		}
		return 1;
	}
}