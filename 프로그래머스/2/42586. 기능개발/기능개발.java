import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] remain = new int[speeds.length];
        for(int i = 0; i < speeds.length; i++){
            int a = (100 - progresses[i]) / speeds[i];
            int b = (100 - progresses[i]) % speeds[i];
            remain[i] = b == 0 ? a : a + 1;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt = 1;
        int last = remain[0];
        for(int i = 1; i < speeds.length; i++){
            if(remain[i] > last){
                ans.add(cnt);
                cnt = 1;
                last = remain[i];
            }else{
                cnt++;
            }
        }
        ans.add(cnt);
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}