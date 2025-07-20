import java.util.*;

class Solution {
    public String[] want;
    public int[] number;
    public HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        this.want = want;
        this.number = number;
        int minDay = 10;
        int answer = 0;
        
        for(int i = 0; i < discount.length; i++){
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            if(i >= 9){
                if(isValid()){
                    answer++;
                }
                map.put(discount[i - 9], map.get(discount[i - 9]) - 1);
            }
        }
        return answer;
    }
    
    public boolean isValid(){
        for(int i = 0; i < want.length; i++){
            if(map.getOrDefault(want[i], 0) < number[i]){
                return false;
            }
        }
        return true;
    }
}