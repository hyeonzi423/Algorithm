import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, D, map[][], ans = 0;	
	static boolean[] visited;
	static PriorityQueue<Enemy> pq;  
	static List<Enemy> enemyList = new ArrayList<>(); 
	
	static class Enemy {
		int x;    
		int y;
		int dist; 
		
		public Enemy(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if (map[i][j] == 1) enemyList.add(new Enemy(i, j, 0));
        	}
        }
        
        visited = new boolean[M];
        combi(0,0);
        System.out.println(ans);
	}
	
	private static void combi(int start, int cnt) {
    	if (cnt == 3) {
    		simulation();
    		return;
    	}
    	
    	for (int i = start; i < M; i++) {
    		if (visited[i]) continue;
    		
    		visited[i] = true;
    		combi(start+1, cnt+1);
    		visited[i] = false;
    	}
    }
	
	private static void simulation() {
		int tmpAns = 0;		
		
		List<Enemy> enemyListCopy = new ArrayList<>();
		for (int i = 0; i < enemyList.size(); i++) {
			int x = enemyList.get(i).x;
			int y = enemyList.get(i).y;
			
			enemyListCopy.add(new Enemy(x, y, 0));
		}
		
		while (!enemyListCopy.isEmpty()) {
			List<Enemy> selectEnemy = new ArrayList<>();
			
			for (int i = 0; i < M; i++) {
				if (visited[i]) {
					pq = new PriorityQueue<>(new Comparator<Enemy>() {
						@Override
						public int compare(Enemy o1, Enemy o2) {
							if (o1.dist != o2.dist) {
								return o1.dist - o2.dist;
							}
							return o1.y - o2.y;
						}
					});
					
					for (int j = 0; j < enemyListCopy.size(); j++) {
						Enemy t = enemyListCopy.get(j);
						int t_dist = Math.abs(N - t.x) + Math.abs(i - t.y);
						if (t_dist <= D) {
							pq.add(new Enemy(t.x, t.y, t_dist));
						}
					}
					
					if (!pq.isEmpty()) {
						boolean check = true;
						Enemy first = pq.poll();
						for (int j = 0; j < selectEnemy.size(); j++) {
							Enemy other = selectEnemy.get(j);
							if (first.x == other.x && first.y == other.y) {
								check = false;
							}
						}
						if (check) selectEnemy.add(new Enemy(first.x, first.y, 0));
					}
				}
			}

			for (int j = 0; j < selectEnemy.size(); j++) {
				Enemy se = selectEnemy.get(j);
				for (int k = enemyListCopy.size() - 1; k >= 0; k--) {
					Enemy e = enemyListCopy.get(k);
					if (se.x == e.x && se.y == e.y) {
						enemyListCopy.remove(k);
						tmpAns++;
					}
				}
			}

			for (int j = enemyListCopy.size() - 1; j >= 0; j--) {
				enemyListCopy.get(j).x += 1;
				if (enemyListCopy.get(j).x == N) enemyListCopy.remove(j);
			}
		}
		
		ans = Math.max(ans, tmpAns);
	}
}