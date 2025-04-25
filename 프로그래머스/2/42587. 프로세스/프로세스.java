import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            q.add(new int[]{i, priorities[i]});
        }
        
        int ans = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll(); // 현재 맨 앞의 item
            boolean hasHiger = false;
            
            for(int[] item : q){ // 남은 항목들을 확인
                if(item[1] > cur[1]){
                    hasHiger = true;
                    break;
                }
            }
            
            if(hasHiger){
                q.add(cur);
            }else{
                if(location == cur[0]) return ans;
                ans++;
            }
        }
        return priorities.length;
    }
}