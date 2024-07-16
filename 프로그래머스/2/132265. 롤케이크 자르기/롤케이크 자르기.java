import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> oMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        
        for(int t : topping){
            if(oMap.containsKey(t)){
                oMap.replace(t, oMap.get(t) + 1);
            }else{
                oMap.put(t, 1);
            }
        }
        
        for(int t : topping){
            if(oMap.get(t) == 1){
                oMap.remove(t);
            }else{
                oMap.replace(t, oMap.get(t)-1);
            }
            
            if(yMap.containsKey(t)){
                yMap.replace(t, yMap.get(t) + 1);
            }else{
                yMap.put(t, 1);
            }
            
            if(oMap.size() == yMap.size()){
                answer++;
            }
        }
        
        
        
        return answer;
    }
}