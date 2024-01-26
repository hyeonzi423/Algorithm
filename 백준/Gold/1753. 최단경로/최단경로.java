import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class EndWeight{
	int e, w;
	
	EndWeight(int e, int w) {
		this.e = e;
		this.w = w;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<EndWeight>> lineInfo = new ArrayList<ArrayList<EndWeight>>();

		
		for(int i = 0; i <= V; i++) {
			lineInfo.add(new ArrayList<>());
		}
		
		for(int i = 0; i< E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			lineInfo.get(start).add(new EndWeight(end, weight));
		}
		
		boolean[] visited = new boolean[V+1];
		int[] cost = new int[V+1];
		for(int i = 1; i <= V; i++) {
			cost[i] = Integer.MAX_VALUE;
		}
		
		cost[K] = 0;
		
		for(int i = 0; i < V; i++) {
			int maxValue = Integer.MAX_VALUE;
			int idx = 0;
			for(int j = 1; j <= V; j++) {
				if (!visited[j] && cost[j] < maxValue) {
					maxValue = cost[j];
					idx = j;
				}
			}
			visited[idx] = true;
			for(int j = 0; j < lineInfo.get(idx).size(); j++) {
				EndWeight now = lineInfo.get(idx).get(j);
				if(cost[now.e] > cost[idx] + now.w) {
					cost[now.e] = cost[idx] + now.w;
				}
			}
		}
		
		for(int i= 1; i<= V; i++) {
			if(cost[i] < Integer.MAX_VALUE) {
				System.out.println(cost[i]);
			}
			else {
				System.out.println("INF");
			}
		}
	}
}