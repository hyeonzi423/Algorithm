import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, R, C, L, ans;
	static int map[][];
	static Object[][] dirX = { {}, { -1, 1, 0, 0 }, { -1, 1 }, { 0, 0 }, { -1, 0 }, { 1, 0 }, { 1, 0 }, { -1, 0 } };
	static Object[][] dirY = { {}, { 0, 0, -1, 1 }, { 0, 0 }, { -1, 1 }, { 0, 1 }, { 0, 1 }, { 0, -1 }, { 0, -1 } };

	static class Point {
		int x, y, t;

		public Point(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(R, C, 0));
		boolean[][] visited = new boolean[N][M];
		visited[R][C] = true;
		ans = 0;

		while (!q.isEmpty()) {
			Point now = q.poll();
			if (now.t >= L)
				break;
			ans++;
			int num = map[now.x][now.y];
			for (int i = 0; i < dirX[num].length; i++) {
				int nx = now.x + (int) dirX[num][i];
				int ny = now.y + (int) dirY[num][i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (map[nx][ny] > 0 && !visited[nx][ny]) {
						int dir = direction((int) dirX[num][i], (int) dirY[num][i]);
						if(canGo(dir, map[nx][ny])) {
							visited[nx][ny] = true;
							q.offer(new Point(nx, ny, now.t + 1));
						}
					}
				}
			}
		}
	}
	
	public static int direction(int a, int b) {
		if(a == -1 && b == 0) {
			return 0;
		}else if(a == 0 && b == 1) {
			return 1;
		}else if(a == 1 && b == 0) {
			return 2;
		}else {
			return 3;
		}
	}

	public static boolean canGo(int dir, int num) {
		boolean flag = false;
		switch (dir) {
		case 0:			
			if(num == 1 || num == 2 || num == 5 || num == 6) flag = true;
			break;
		case 1:			
			if(num == 1 || num == 3 || num == 6 || num == 7) flag = true;
			break;
		case 2:			
			if(num == 1 || num == 2 || num == 4 || num == 7) flag = true;
			break;
		case 3:			
			if(num == 1 || num == 3 || num == 4 || num == 5) flag = true;
			break;
		}
		return flag;
	}
}