import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, K, ans;
	static ArrayList<Microbe>[][] map;
	static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Microbe> microbes;
	
	static class Microbe{
		int x, y, num, dir;

		public Microbe(int x, int y, int num, int dir) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Microbe [x=" + x + ", y=" + y + ", num=" + num + ", dir=" + dir + "]";
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int x, y, n, d;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // map의 크기
			M = Integer.parseInt(st.nextToken()); // 격리 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 군집의 수
			
			microbes = new ArrayList<>();
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				n = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				microbes.add(new Microbe(x, y, n, d-1));
			}
			
			for(int i = 0; i < M; i++) {
				move();
				merge();
				//System.out.println();
			}
			cal();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void move() {
		map = new ArrayList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for(int i = 0; i < microbes.size(); i++) {
			Microbe m = microbes.get(i);
			if(m.num <= 0) continue;
			int nx = m.x + dx[m.dir];
			int ny = m.y + dy[m.dir];
			if(nx == 0 || nx == N-1 || ny == 0 || ny == N-1) {
				m.num /= 2;
				if(m.num <= 0) {
					continue;
				}
				if(m.dir == 0) m.dir = 1;
				else if(m.dir == 1) m.dir = 0;
				else if(m.dir == 2) m.dir = 3;
				else if(m.dir == 3) m.dir = 2;
				map[nx][ny].add(new Microbe(nx, ny, m.num, m.dir));
			}else {
				map[nx][ny].add(new Microbe(nx, ny, m.num, m.dir)); 
			}
		}
	}
	
	public static void merge() {
		microbes.clear();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j].size() > 1) {
					int maxSize = 0, direction = 0, sum = 0;
					for(Microbe m : map[i][j]) {
						sum += m.num;
						if(maxSize < m.num) {
							maxSize = m.num;
							direction = m.dir;
						}
					}
					map[i][j].clear();
					map[i][j].add(new Microbe(i, j, sum, direction));
					microbes.add(new Microbe(i, j, sum, direction));
				}else if(map[i][j].size() == 1) {
					microbes.add(map[i][j].get(0));
				}
			}
		}
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				if(map[i][j].size() == 0) continue;
//				for(Microbe m : map[i][j]) {
//					System.out.print(m);
//				}
//				System.out.println();
//			}
//		}
		
	}
	
	public static void cal() {
		ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j].size() == 0) continue;
				for(Microbe m : map[i][j]) {
					ans += m.num;
				}
			}
		}
	}

}
