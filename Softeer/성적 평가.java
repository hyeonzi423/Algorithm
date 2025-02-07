import java.io.*;
import java.util.*;

public class Main {

    public static class Participant implements Comparable<Participant> {
        int idx, score;

        Participant(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }

        @Override
        public int compareTo(Participant o) {
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] rank = new int[4][N];
        int[] score = new int[N];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Participant> pq = new PriorityQueue<>();
            for (int j = 0; j < N; j++) {
                int s = Integer.parseInt(st.nextToken());
                score[j] += s;
                pq.add(new Participant(j, s));
            }
            calculateRank(pq, rank[i]);
        }

        PriorityQueue<Participant> finalRankPq = new PriorityQueue<>();
        for (int j = 0; j < N; j++) {
            finalRankPq.add(new Participant(j, score[j]));
        }
        calculateRank(finalRankPq, rank[3]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(rank[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void calculateRank(PriorityQueue<Participant> pq, int[] rank) {
        Participant now = pq.poll();
        rank[now.idx] = 1;
        int lastScore = now.score;
        int sameCnt = 0;
        int nowRank = 1;

        while (!pq.isEmpty()) {
            now = pq.poll();
            if (lastScore == now.score) {
                rank[now.idx] = nowRank;
                sameCnt++;
            } else {
                nowRank += sameCnt;
                rank[now.idx] = ++nowRank;
                lastScore = now.score;
                sameCnt = 0;
            }
        }
    }
}
