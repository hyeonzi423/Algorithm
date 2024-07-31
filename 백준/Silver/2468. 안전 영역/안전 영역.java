import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		int ans = 1;
		
		int max = -1, min = 101;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, graph[i][j]);
				min = Math.min(min, graph[i][j]);
			}
		}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for(int t = min; t <= max; t++) {
			boolean[][] visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j =0; j < N; j++) {
					if(graph[i][j] < t) {
						visited[i][j] = true;
					}
				}
			}
			
			Queue<int[]> q = new LinkedList<>();
			int count = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						count++;
						q.clear();
						q.add(new int[] {i, j});
						while(!q.isEmpty()) {
							int[] now = q.poll();
							for(int k = 0; k < 4; k++) {
								int nx = now[0] + dx[k];
								int ny = now[1] + dy[k];
								if(0 > nx || nx >= N || 0 > ny || ny >= N) continue;
								if(visited[nx][ny]) continue;
								visited[nx][ny] = true;
								q.add(new int[] {nx, ny});
							}
						}
					}
				}
			}
			ans = Math.max(ans, count);	
		}
		System.out.println(ans);
	}
}