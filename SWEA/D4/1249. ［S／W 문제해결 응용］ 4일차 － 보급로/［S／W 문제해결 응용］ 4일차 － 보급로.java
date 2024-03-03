import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.awt.Point;

public class Solution {
	static int N, map[][], ans;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			bfs();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		int[][] newMap = new int[N][N];
		boolean visited[][] = new boolean[N][N];
		visited[0][0] = true;
		q.offer(new Point(0, 0));

		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (!isRange(nx, ny)) continue;
				if (visited[nx][ny]) {
					if (newMap[now.x][now.y] + map[nx][ny] < newMap[nx][ny]) {
						newMap[nx][ny] = newMap[now.x][now.y] + map[nx][ny];
						q.offer(new Point(nx, ny));
					}
				} else {
					visited[nx][ny] = true;
					q.offer(new Point(nx, ny));
					newMap[nx][ny] = newMap[now.x][now.y] + map[nx][ny];
				}
			}
		}
		ans = newMap[N - 1][N - 1];
	}

	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

}