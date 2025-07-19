import java.util.*;

class Solution{
    public int solution(String s){
        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(dq.size() == 0 || dq.peekLast() != s.charAt(i)){
                dq.addLast(s.charAt(i));
            }else{
                dq.removeLast();
            }
        }

        return dq.size() == 0 ? 1 : 0;
    }
}