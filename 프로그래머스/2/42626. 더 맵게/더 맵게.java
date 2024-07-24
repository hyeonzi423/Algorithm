import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }
        while(pq.peek() < K && pq.size() >= 2){
            int one = pq.poll();
            int two = pq.poll();
            pq.add(one + two*2);
            answer++;
        }
        return pq.peek() >= K ? answer : -1;
    }
}