import java.util.*;
class Solution {
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
    
    public void dfs(String str, int cnt){
        if(cnt > 5) return;
        
        list.add(str);
        
        for(int i = 0; i < 5; i++){
            dfs(str + "AEIOU".charAt(i), cnt + 1);
        }
    }
}