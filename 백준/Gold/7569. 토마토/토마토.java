import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		Queue<Point> q = new LinkedList<Point>();
		int ans = 0;
		int zero = 0;

		int[][] tomato = new int[n * h][m]; // 기본 토마토 정보 저장
		int[][] date = new int[n * h][m]; // 기본 토마토 + 익는 날 정보 저장
		int[][] visited = new int[n * h][m];

		for (int i = 0; i < n * h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				tomato[i][j] = tmp;
				if (tmp == 1) {
					q.offer(new Point(i, j));
					visited[i][j] = 1;
					date[i][j] = 1;
				}
				else if(tmp == 0) {
					zero += 1;
				}
				else {
					date[i][j] = -1;
				}
			}
		}

		int[] nxList = { -1, 0, 1, 0 };
		int[] nyList = { 0, 1, 0, -1 };
		int nx, ny;
		if (zero != 0) {
			while (q != null) {
				Point now = q.poll();
				if (now == null) {
					break;
				}
				//System.out.println(now.x + " " + now.y);
				for (int i = 0; i < 4; i++) {
					nx = now.x + nxList[i];
					ny = now.y + nyList[i];
					int limitMin = now.x /n <= 0 ? 0 : (int)(now.x /n); 
					if (limitMin*n <= nx && nx < (limitMin+1)*n && 0 <= ny && ny < m) {
						if (tomato[nx][ny] == 0 && visited[nx][ny] == 0) {
							date[nx][ny] = date[now.x][now.y] + 1;
							visited[nx][ny] = 1;
							q.offer(new Point(nx, ny));
						}
					}
				}
				int upCheck = now.x + n;
				int downCheck = now.x - n;
	
				if (upCheck < n * h) {
					if (tomato[upCheck][now.y] == 0 && visited[upCheck][now.y] == 0) {
						date[upCheck][now.y] = date[now.x][now.y] + 1;
						visited[upCheck][now.y] = 1;
						q.offer(new Point(upCheck, now.y));
					}
				}
	
				if (downCheck >= 0) {
					if (tomato[downCheck][now.y] == 0 && visited[downCheck][now.y] == 0) {
						date[downCheck][now.y] = date[now.x][now.y] + 1;
						visited[downCheck][now.y] = 1;
						q.offer(new Point(downCheck, now.y));
					}
				}
//				for (int i = 0; i < n * h; i++) {
//					System.out.println(Arrays.toString(date[i]));
//					if (i == n-1) {
//						System.out.println("-------------------");
//					}
//				}
//				System.out.println();
	
			}
			boolean check = true;
			for (int i = 0; i < n * h; i++) {
				for (int j = 0; j < m; j++) {
					if (date[i][j] == 0 && tomato[i][j] == 0) {
						ans = -1;
						check = false;
						break;
	
					} else {
						ans = Math.max(ans, date[i][j]);
					}
				}
				if(check == false) {
					break;
				}
				
			}
			if(ans != -1) {
				System.out.println(ans-1);
			}
			else {
				System.out.println(ans);
			}
		}
		else {
			System.out.println(ans);
		}
	}
}