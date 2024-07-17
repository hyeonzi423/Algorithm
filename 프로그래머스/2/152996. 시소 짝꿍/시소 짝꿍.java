import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        
        Arrays.sort(weights);
        for(int w : weights){
            Double a = w * 1.0;
            Double b = (w * 2.0) / 3.0;
            Double c = (w * 3.0) / 4.0;
            Double d = (w * 1.0) / 2.0;
            
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            map.put(w*1.0, map.getOrDefault(w*1.0, 0) + 1);
        }
        return answer;
    }
}