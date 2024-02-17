import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, iceCnt;
	static int map[][], tmpMap[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Pos> q;
	static boolean[][] visited;
	static boolean check;

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 0;
		int nowIceCnt = bfs();
		if (nowIceCnt > 1) {
			System.out.println(0);
		} else {
			check = true;
			while (nowIceCnt != 0) {
				meltingIce();
				// print();
				year++;
				nowIceCnt = bfs();
				if (nowIceCnt > 1) {
					break;
				}else if(nowIceCnt == 0) {
					check = false;
				}
			}
			System.out.println(check ? year : 0);
		}

	}

	public static void meltingIce() {
		tmpMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					continue;
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					if (map[nx][ny] == 0)
						cnt++;
				}
				tmpMap[i][j] = map[i][j] - cnt < 0 ? 0 : map[i][j] - cnt;
			}
		}
		map = tmpMap;
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

	public static int bfs() {
		iceCnt = 0;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0 && !visited[i][j]) {
					q = new ArrayDeque<>();
					q.offer(new Pos(i, j));
					visited[i][j] = true;
					iceCnt++;
					while (!q.isEmpty()) {
						Pos tmp = q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = tmp.x + dx[k];
							int ny = tmp.y + dy[k];
							if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 0)
								continue;
							q.offer(new Pos(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
		return iceCnt;
	}
}