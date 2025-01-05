import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] goal = new int[3];

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					goal[0] = i;
					goal[1] = j;
				}
			}
		}

		boolean[][] visited = new boolean[N][M];
		int[][] ans = new int[N][M];

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		Queue<int[]> q = new LinkedList<>();
		q.add(goal);
		visited[goal[0]][goal[1]] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (0 > nx || nx >= N || 0 > ny || ny >= M) {
					continue;
				}
				if (visited[nx][ny]) {
					continue;
				}
				if (map[nx][ny] == 0) {
					continue;
				}
				q.add(new int[] { nx, ny, now[2] + 1 });
				visited[nx][ny] = true;
				ans[nx][ny] = now[2] + 1;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					sb.append(-1).append(" ");
				} else {
					sb.append(ans[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}
