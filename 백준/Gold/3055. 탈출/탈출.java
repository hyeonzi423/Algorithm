//비어 있는 곳 . 물 * 돌 X 굴 D 고슴도치 S 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C;
	static int ans = Integer.MAX_VALUE;
	static char map[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Point> dochi = new LinkedList<>();
	static Queue<Point> water = new LinkedList<>();

	static class Point {
		int x, y, time;

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					dochi.add(new Point(i, j, 0));
				} else if (map[i][j] == '*') {
					water.add(new Point(i, j));
				}
			}
		}
		bfs();
		System.out.println(ans == Integer.MAX_VALUE ? "KAKTUS" : ans);
	}

	public static void bfs() {
		while (!dochi.isEmpty()) {
			int waterSize = water.size();
			for (int i = 0; i < waterSize; i++) {
				Point now = water.poll();
				for (int k = 0; k < 4; k++) {
					int nx = now.x + dx[k];
					int ny = now.y + dy[k];
					if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {
						map[nx][ny] = '*';
						water.add(new Point(nx, ny));
					}
				}
			}
			int dochiSize = dochi.size();
			for (int i = 0; i < dochiSize; i++) {
				Point now = dochi.poll();
				for (int k = 0; k < 4; k++) {
					int nx = now.x + dx[k];
					int ny = now.y + dy[k];
					if (0 > nx || nx >= R || 0 > ny || ny >= C)
						continue;
					if (map[nx][ny] == 'D') {
						ans = Math.min(ans, now.time + 1);
						return;
					} else if (map[nx][ny] == '.') {
						map[nx][ny] = 'S';
						dochi.add(new Point(nx, ny, now.time + 1));
					}
				}
			}
		}
	}

}