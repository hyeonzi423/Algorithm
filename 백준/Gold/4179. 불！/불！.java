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

		boolean[][] map = new boolean[N][M];

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int[][] jihoonTime = new int[N][M];
		int[][] fireTime = new int[N][M];

		Queue<int[]> jihoonQueue = new LinkedList<>();
		Queue<int[]> fireQueue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == '#') {
					map[i][j] = false;
				} else if (str.charAt(j) == '.') {
					map[i][j] = true;
				} else if (str.charAt(j) == 'J') {
					jihoonTime[i][j] = 1;
					jihoonQueue.add(new int[] { i, j });
				} else {
					fireTime[i][j] = 1;
					fireQueue.add(new int[] { i, j });
				}
			}
		}

		while (!fireQueue.isEmpty()) {
			int[] now = fireQueue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				if (!map[nx][ny] || fireTime[nx][ny] > 0) {
					continue;
				}
				fireTime[nx][ny] = fireTime[now[0]][now[1]] + 1;
				fireQueue.add(new int[] { nx, ny });
			}
		}

		while (!jihoonQueue.isEmpty()) {
			int[] now = jihoonQueue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					System.out.println(jihoonTime[now[0]][now[1]]);
					return;
				}
				if (!map[nx][ny] || jihoonTime[nx][ny] > 0) {
					continue;
				}
				if (fireTime[nx][ny] == 0 || jihoonTime[now[0]][now[1]] + 1 < fireTime[nx][ny]) {
					jihoonTime[nx][ny] = jihoonTime[now[0]][now[1]] + 1;
					jihoonQueue.add(new int[] { nx, ny });
				}
			}
		}

		System.out.println("IMPOSSIBLE");
	}
}