import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int ans;
	static int[] plan, cost;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			cost = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			plan = new int[13];
			for(int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = cost[3];
			dfs(1, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
        System.out.println(sb);
	}
	
	public static void dfs(int nowMonth, int sum) {
		if(sum >= ans) return;
		if(nowMonth > 12) {
			ans = Math.min(ans, sum);
			return;
		}
		if(plan[nowMonth] != 0) {
			dfs(nowMonth + 1, sum + plan[nowMonth] * cost[0]); // 1일
			dfs(nowMonth + 1, sum + cost[1]); // 1달
			dfs(nowMonth + 3, sum + cost[2]); // 3달
		}else {
			dfs(nowMonth+1, sum);
		}
	}
}