import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        PriorityQueue<int[]> remain = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[0], p2[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[1], p2[1]));
        for(int[] j : jobs){
            remain.add(j);
        }
        while(pq.size() != 0 || remain.size() != 0){
            while(remain.size() > 0){
                if(remain.peek()[0] <= time){
                    pq.add(remain.poll());
                }else{
                    break;
                }
            }
            if(pq.size() > 0){
                int[] pop = pq.poll();
                answer += time + pop[1] - pop[0];
                time += pop[1];
            }else{
                time++;
            }
        }
        return answer/jobs.length; 
    }
}