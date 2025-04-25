import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int time = 0;
        int totalTime = 0;
        int idx = 0;
        int n = jobs.length;
        
        while(idx < n || !pq.isEmpty()){
            while(idx < n && jobs[idx][0] <= time){
                pq.add(jobs[idx++]);
            }
            if(!pq.isEmpty()){
                int[] cur = pq.poll();
                time += cur[1];
                totalTime += (time - cur[0]);
            }else{
                time = jobs[idx][0];
            }
        }
        return totalTime / n;
    }
}