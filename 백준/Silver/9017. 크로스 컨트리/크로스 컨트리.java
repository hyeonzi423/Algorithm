import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			int[] team = new int[N];
			HashMap<Integer, Integer> count = new HashMap<>();
			for(int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				team[i] = tmp;
				if(count.containsKey(tmp)) {
					count.replace(tmp, count.get(tmp) + 1);
				}else {
					count.put(tmp, 1);
				}
			}
			
			HashSet<Integer> under = new HashSet<>();
			for(Integer key: count.keySet()) {
				if(count.get(key) < 6) {
					under.add(key);
				}
			}
			
			int personalScore = 1;
			HashMap<Integer, int[]> score = new HashMap<>(); // 4등까지 점수, 5등 점수, 현재 더한 사람의 수
			for(int i = 0; i < N; i++) {
				if(!under.contains(team[i])) {
					if(score.containsKey(team[i])) {
						int[] tmp = score.get(team[i]);
						if(tmp[2] < 4) {
							tmp[0] += personalScore++;
						}else if(tmp[2] == 4) {
							tmp[1] = personalScore++;
						}else {
							personalScore++;
						}
						tmp[2]++;
						score.replace(team[i], tmp);
					}else {
						score.put(team[i], new int[]{personalScore++, 0, 1});
					}
				}
			}
			
			int winner = -1, totalScore = 10000, five = 10000;
			for(Integer key : score.keySet()) {
				int[] now = score.get(key);
				if(totalScore>now[0] || (totalScore == now[0] && five > now[1])) {
					winner = key;
					totalScore = now[0];
					five = now[1];
				}
			}
			System.out.println(winner);
		}
	}
}