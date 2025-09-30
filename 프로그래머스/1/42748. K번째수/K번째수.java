import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for(int[] c : commands){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = c[0]-1; i < c[1]; i++){
                pq.add(array[i]);
            }
            for(int i = 0; i < c[2] - 1; i++){
                pq.poll();
            }
            answer[idx++] = pq.poll();
        }
        return answer;
    }
}