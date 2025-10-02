import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < participant.length; i++){
            hm.put(participant[i], hm.getOrDefault(participant[i], 0) + 1);
        }
        
        for(int i = 0; i < completion.length; i++){
            hm.put(completion[i], hm.get(completion[i]) - 1);
        }
        
        for(String name : hm.keySet()){
            if(hm.get(name) != 0){
                return name;
            }
        }
        
        return participant[participant.length - 1];
    }
}