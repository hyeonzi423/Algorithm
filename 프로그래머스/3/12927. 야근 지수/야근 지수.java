import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works){
            q.add(w);
        }
        for(int i = 0; i < n; i++){
            int now = q.poll();
            if(now == 0) return 0;
            q.add(now-1);
        }
        while(!q.isEmpty()){
            answer += Math.pow(q.poll(), 2);
        }
        return answer;
    }
}