import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static int[][] map = new int[9][9];
	static ArrayList<Point> empty = new ArrayList<>();
	static boolean flag = false;
	boolean[] visited = new boolean[10];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		for(int i = 0; i < 9; i++) {
			String st = br.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = st.charAt(j) - '0';
				if(map[i][j] == 0) {
					empty.add(new Point(i, j));
				}
			}
		}
		dfs(0);
	}
	
	public static void dfs(int idx) {
		if(idx == empty.size() || flag) {
			for(int i = 1; i <= 9; i++) {
				for(int j = 1; j <= 9; j++) {
					System.out.print(map[i-1][j-1]);
				}
				System.out.println();
			}
			System.exit(0);;
		}
		
		Point now = empty.get(idx);

		boolean[] visited = new boolean[10];
		for(int i = 1; i <= 9; i++) {
			visited[map[now.x][i-1]] = true;
			visited[map[i-1][now.y]] = true;
		}
		for(int i = (now.x/3) * 3; i < (now.x/3)*3 + 3; i++) {
			for(int j = (now.y/3)* 3; j < (now.y/3)* 3 + 3; j++) {
				visited[map[i][j]] = true;
			}
		}
		
		for(int i = 1; i < 10; i++) {
			if(!visited[i]) {
				map[now.x][now.y] = i;
				dfs(idx+1);
				map[now.x][now.y] = 0;
			}
		}
	}

}