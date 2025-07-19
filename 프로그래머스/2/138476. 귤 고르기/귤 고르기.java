import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> (map.get(b) - map.get(a)));
        
        int tan = 0;
        for(int i = 0; i < keys.size(); i++){
            if(tan >= k){
                return i;
            }else{
                tan += map.get(keys.get(i));
            }
        }
        return keys.size();
    }
}