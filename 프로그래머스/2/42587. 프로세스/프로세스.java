import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            q.add(new int[]{priorities[i], i});
            pq.add(priorities[i]);
        }
        
        int turn = 1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            if(now[0] == pq.peek()){
                if(now[1] == location){
                    return turn;
                }
                turn++;
                pq.poll();
            }else{
                q.add(now);
            }
        }
        return turn;
    }
}