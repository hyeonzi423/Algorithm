import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] population = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] tmp;
		boolean[][] visited;
		boolean flag = true;
		int ans = 0;

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		while (true) {
			if (!flag) {
				break;
			}
			flag = false;
			visited = new boolean[N][N];
			tmp = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						ArrayList<Point> pos = new ArrayList<>();
						int total = population[i][j];
						visited[i][j] = true;
						pos.add(new Point(i, j));
						Queue<Point> q = new LinkedList<>();
						q.add(new Point(i, j));

						while (!q.isEmpty()) {
							Point now = q.poll();
							for (int k = 0; k < 4; k++) {
								int nx = now.x + dx[k];
								int ny = now.y + dy[k];
								if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
									continue;
								}
								if (visited[nx][ny]) {
									continue;
								}
								int gap = Math.abs(population[now.x][now.y] - population[nx][ny]);
								if (gap >= L && gap <= R) {
									total += population[nx][ny];
									visited[nx][ny] = true;
									q.add(new Point(nx, ny));
									pos.add(new Point(nx, ny));
								}
							}
						}
						int newPop = total / pos.size();
						if (pos.size() > 1) {
							flag = true;
						}
						for (Point p : pos) {
							tmp[p.x][p.y] = newPop;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					population[i][j] = tmp[i][j];
				}
			}
			if (flag) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}