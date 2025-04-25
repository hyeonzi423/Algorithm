import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.add(s);
        }
        
        while(pq.size() >= 2){
            if(pq.peek() >= K){
                break;
            }
                
            int one = pq.poll();
            int two = pq.poll();
            pq.add(one + two*2);
            answer++;
        }
    
        return pq.peek() < K ? -1 : answer;
    }
}