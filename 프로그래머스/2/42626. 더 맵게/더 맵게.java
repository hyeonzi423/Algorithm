import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }
        
        int answer = 0;
        while(pq.size() >= 2 && pq.peek() < K){
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b*2);
            answer++;
        }
        
        return pq.peek() < K ? -1 : answer;
    }
}