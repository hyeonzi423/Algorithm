import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int time = 0;  // 현재 시간
        int total = 0; // 총 소요 시간 합
        int idx = 0;   // jobs 배열 인덱스
        int count = jobs.length;

        while (idx < count || !pq.isEmpty()) {
            while (idx < count && jobs[idx][0] <= time) {
                pq.add(jobs[idx]);
                idx++;
            }

            if (!pq.isEmpty()) { 
                int[] job = pq.poll();
                time += job[1]; 
                total += (time - job[0]); 
            } else {
                time = jobs[idx][0];
            }
        }

        return total / count;
    }
}
