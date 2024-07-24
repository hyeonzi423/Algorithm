import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < prices.length-1; i++){
            int cnt = 1;
            for(int j = i+1; j < prices.length-1; j++){
                if(prices[j] >= prices[i]){
                    cnt++;
                }else{
                    break;
                }
            }
            cnt = cnt == 0 ? 1 : cnt;
            arr.add(cnt);
        }
        
        int[] ans = new int[prices.length];
        for(int i = 0; i < prices.length-1; i++){
            ans[i] = arr.get(i);
        }
        return ans;
    }
}