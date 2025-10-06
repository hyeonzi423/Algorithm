import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int c = 0; c < commands.length; c++){
            int[] now = commands[c];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            
            for(int i = now[0] - 1; i < now[1]; i++){
                pq.add(array[i]);
            }
            
            for(int i = 0; i < now[2] - 1; i ++){
                pq.poll();
            }
            
            answer[c] = pq.poll();
        }
        return answer;
    }
}