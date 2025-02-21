import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }
        
        while(pq.size() >= 2){
            int min = pq.poll();
            if(min >= K){
                break;
            }
            int nextMin = pq.poll();
            pq.add(min + nextMin * 2);
            answer++;
        }
        
        return pq.peek() < K ? -1 : answer;
    }
}