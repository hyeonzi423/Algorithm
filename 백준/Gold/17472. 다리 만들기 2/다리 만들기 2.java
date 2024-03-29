import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int map[][], N, M, parent[];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static ArrayList<Island> islands = new ArrayList<>();
	static ArrayList<Edge> edges = new ArrayList<>();
	
	static class Island{
		int index;
		ArrayList<Point> points;
		
		public Island(int index, ArrayList<Point> points) {
			this.index = index;
			this.points = points;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int dis, from, to;

		public Edge(int dis, int from, int to) {
			this.dis = dis;
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dis - o.dis;
		}

		@Override
		public String toString() {
			return "Edge [dis=" + dis + ", from=" + from + ", to=" + to + "]";
		}

		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		findEdge();

		
		Collections.sort(edges);
		int ans = 0, cnt = 0;
		int islandNum = islands.size();
//		System.out.println(islandNum);
//		for (Edge e : edges) {
//			System.out.println("b " + e);
//		}
		makeSet(islandNum);
		for(Edge e : edges) {
			if(union(e.from, e.to)) {
				//System.out.println(e);
				ans += e.dis;
				cnt++;
				//System.out.println(cnt + " " + islandNum);
			}
		}
		
		boolean f = isAllConnected(islandNum);
		System.out.println(f && ans != 0? ans : -1);
	}
	
	public static boolean isRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
	
	public static void bfs() {
		int idx = 1;
		boolean visited[][] = new boolean[N][M];
		Queue<Point> q = new ArrayDeque<>();
		ArrayList<Point> islandPoint = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					q = new ArrayDeque<>();
					visited[i][j] = true;
					q.add(new Point(i, j));
					map[i][j] = idx++;
					
					while(!q.isEmpty()) {
						Point now = q.poll();
						islandPoint.add(now);
						for(int k = 0; k < 4; k++) {
							int nx = now.x + dx[k];
							int ny = now.y + dy[k];
							if(!isRange(nx, ny)) continue;
							if(visited[nx][ny] || map[nx][ny] == 0) continue;
							visited[nx][ny] = true;
							q.add(new Point(nx, ny));
							map[nx][ny] = map[i][j];
						}
					}
					islands.add(new Island(idx, islandPoint));
				}
			}
		}
		//print(map);
	}
	
	private static boolean isAllConnected(int lands) {
		boolean flag = true;
		int a = find(1);
        for (int i = 2; i <= lands; i++) {
            if (a != find(i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
	
	public static void makeSet(int x) {
		parent = new int[x+1];
		for(int i = 0; i < x+1; i++) {
			parent[i] = i;
		}
	}
	
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parent[bRoot] = aRoot;
		return true;
	}
	
	
	public static void findEdge() {
		int cnt = 0;
		for(Island tmp : islands) {
			for(Point p : tmp.points) {
				for(int i = 0; i < 4; i++) {
					Edge ret = check(p, i);
					if(ret != null) {
						edges.add(ret);
						//System.out.println("ret " + ret);
					}
				}
			}
		}
	}
	
	public static Edge check(Point now, int d) { 
		int tmpdis = 0;
		int nowNum = map[now.x][now.y];
		Edge ret = null;
		int x = now.x, y = now.y;
		while(true) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(!isRange(nx, ny)) break;
			if(map[nx][ny] == 0) {
				tmpdis++;
				x = nx;
				y = ny;
			}else if(map[nx][ny] == nowNum) {
				break;
			}else {
				if(tmpdis < 2) break;
				else {
					Edge e = new Edge(tmpdis, map[now.x][now.y], map[nx][ny]);
					ret = e;
					//System.out.println("e " + e + "d" + d);
					break;
				}
			}
		}
		return ret;
	}
	public static void print(int[][] map) {
		for(int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}