import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        String now = words[0];
        HashSet<String> done = new HashSet<>();
        done.add(now);
        
        for(int i = 1; i < words.length; i++){
            if(now.charAt(now.length() - 1) != words[i].charAt(0) || done.contains(words[i])){
                return new int[]{i % n + 1, i / n + 1};
            }
            done.add(words[i]);  
            now = words[i];
        }

        return new int[]{0, 0};
    }
}