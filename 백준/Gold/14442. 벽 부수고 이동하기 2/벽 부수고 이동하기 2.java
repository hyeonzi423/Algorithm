import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = -1;
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		int[][] visited = new int[N][M];
		for(int i = 0; i < N; i++) {			
			Arrays.fill(visited[i], -1);
		}
		
		Queue<int[]> q = new LinkedList<>(); // x, y, 남은 k 수, ans 현재까지 카운트 수
		q.add(new int[] { 0, 0, K, 1 });
		visited[0][0] = K; // 현재 위치에서 벽을 부술 수 있는 남은 수로 방문 처리
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] == N - 1 && now[1] == M-1) {
				ans = now[3];
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if(map[nx][ny] == 1 && now[2] <= 0) continue; // 나아갈 수 없음

				int newK = map[nx][ny] == 0 ? now[2] : now[2] - 1;
				
				if (newK <= visited[nx][ny]) continue;
				
				visited[nx][ny] = newK; 
				q.add(new int[] {nx, ny, newK, now[3] + 1});
			}
		}
		
		System.out.println(ans);
	}
}