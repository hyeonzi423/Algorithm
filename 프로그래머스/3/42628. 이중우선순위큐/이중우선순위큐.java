import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        for(String op : operations){
            String[] o = op.split(" ");
            if(o[0].equals("I")){
                max.offer(Integer.parseInt(o[1]));
                min.offer(Integer.parseInt(o[1]));
            }else if(o[1].equals("1") && max.size() > 0){
                int pop = max.poll();
                min.remove(pop);
            }else if(o[1].equals("-1") && max.size() > 0) {
                int pop = min.poll();
                max.remove(pop);
            }
        }
        
        int[] answer = new int[] {0, 0};
        answer[0] = max.size() > 0 ? max.peek() : 0;
        answer[1] = min.size() > 0 ? min.peek() : 0;
        return answer;
    } 
} 