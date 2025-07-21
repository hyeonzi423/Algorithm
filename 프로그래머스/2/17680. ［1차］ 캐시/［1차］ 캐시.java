import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities){
        if(cacheSize == 0) return cities.length * 5;
        
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        
        for(String c : cities){
            String cl = c.toLowerCase();
            if(cache.contains(cl)){
                cache.offer(cl);
                cache.remove(cl);
                answer += 1;
            } else if(cache.size() < cacheSize){
                cache.offer(cl);
                answer += 5;
            } else if(cache.size() == cacheSize){
                cache.poll();
                cache.offer(cl);
                answer += 5;
            }
        }
        return answer;
    }
}