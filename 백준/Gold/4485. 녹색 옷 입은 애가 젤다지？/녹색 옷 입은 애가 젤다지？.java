import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, dp;
	static int N, ans;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Point implements Comparable<Point>{
		int x, y, v;

		public Point(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public int compareTo(Point o) {
			return this.v - o.v;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			
			dp = new int[N][N];
			for(int i = 0; i <N; i++) {
				for(int j = 0; j < N; j++) {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs();
			System.out.println("Problem " + t + ": " + ans);
			t++;
		}

	}
	
	public static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0, 0, map[0][0]));
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			if(now.x == N-1 && now.y == N-1) {
				ans = now.v;
			}
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(0 > nx || nx >= N || 0 > ny || ny >= N) continue;
				if(now.v + map[nx][ny] < dp[nx][ny]) {
					dp[nx][ny] = now.v + map[nx][ny];
					pq.add(new Point(nx, ny, now.v + map[nx][ny]));
				}
			}
		}
		
	}

}