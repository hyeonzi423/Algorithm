import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String o : operations){
            if(o.equals("D 1")){
                minQ.remove(maxQ.poll());
            }else if(o.equals("D -1")){
                maxQ.remove(minQ.poll());
            }else{
                String[] str = o.split(" ");
                minQ.add(Integer.parseInt(str[1]));
                maxQ.add(Integer.parseInt(str[1]));
            }
        }
        if(maxQ.size() == 0 && minQ.size() == 0){
            return answer;
        }else{
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();        
            return answer;
        }
    }  
}