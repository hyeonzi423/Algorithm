import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

	static class Team {
		int idx, tryCnt, lastSubmit;
		HashMap<Integer, Integer> hm;

		public Team(int idx, int tryCnt, int lastSubmit, HashMap<Integer, Integer> hm) {
			this.idx = idx;
			this.tryCnt = tryCnt;
			this.lastSubmit = lastSubmit;
			this.hm = hm;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 팀의 수
			int P = Integer.parseInt(st.nextToken()); // 문제의 수
			int M = Integer.parseInt(st.nextToken()); // 나의 팀 id
			int L = Integer.parseInt(st.nextToken()); // 로그의 수
			Team[] team = new Team[N + 1];

			for (int i = 1; i <= N; i++) {
				team[i] = new Team(i, 0, 0, new HashMap<>());
			}

			for (int i = 0; i < L; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				int pIdx = Integer.parseInt(st.nextToken());
				int score = Integer.parseInt(st.nextToken());

				team[idx].lastSubmit = i;
				team[idx].tryCnt++;
				int tmpScore = team[idx].hm.getOrDefault(pIdx, 0);
				team[idx].hm.put(pIdx, Math.max(tmpScore, score));
			}

			int before = 0;
			int myScore = getScore(team[M].hm);
			int myLastSubmit = team[M].lastSubmit;
			int myTryCnt = team[M].tryCnt;

			for (Team t : team) {
				if (t == null || t.idx == M)
					continue;

				int nowScore = getScore(t.hm);
				if (nowScore > myScore) {
					before++;
					continue;
				}
				if (nowScore == myScore && t.tryCnt < myTryCnt) {
					before++;
					continue;
				}
				if (nowScore == myScore && t.tryCnt == myTryCnt && t.lastSubmit < myLastSubmit) {
					before++;
					continue;
				}
			}
			sb.append(before + 1).append("\n");
		}
		System.out.println(sb);
	}

	public static int getScore(HashMap<Integer, Integer> hm) {
		int ret = 0;
		for (Integer k : hm.keySet()) {
			ret += hm.get(k);
		}
		return ret;
	};
}