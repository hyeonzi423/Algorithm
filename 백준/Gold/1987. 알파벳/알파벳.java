import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C, cnt, ans = 1;
	static char[][] map;
	static boolean[] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		visited = new boolean[26];
		visited[(int) map[0][0] - 65] = true;
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	public static void dfs(int x, int y, int cnt) {
		ans = Math.max(ans, cnt);
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= R || ny < 0 || ny >= C ) continue;
			if(visited[(int) map[nx][ny] - 65]) continue;
			visited[(int) map[nx][ny] - 65] = true;
			dfs(nx, ny, cnt+1);
			visited[(int) map[nx][ny] - 65] = false;
		}
	}

}