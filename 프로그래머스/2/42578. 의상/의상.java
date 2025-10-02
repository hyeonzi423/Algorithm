import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clo = new HashMap<>();
        
        for(String[] c : clothes){
            clo.put(c[1], clo.getOrDefault(c[1], 0) + 1);
        }
        
        int answer = 1;
        for(String key : clo.keySet()){
            answer *= (clo.get(key) + 1);
        }
        return answer - 1;
    }
}