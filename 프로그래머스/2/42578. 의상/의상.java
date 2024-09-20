import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clo = new HashMap<>();
        for(String[] c: clothes){
            clo.put(c[1], clo.getOrDefault(c[1], 0) + 1);
        }
        for(int x : clo.values()){
            answer *= (x + 1);
        }
        return answer - 1;
    }
}