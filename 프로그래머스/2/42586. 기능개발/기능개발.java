import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] remain = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++){
            int ret = (100 - progresses[i]) % speeds[i];
            int day = (100 - progresses[i]) / speeds[i];
            remain[i] = ret == 0 ? day : day + 1;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 1;
        int last = remain[0];
        for(int i = 1; i < progresses.length; i++){
            if(remain[i] > last){
                list.add(cnt);
                cnt = 1;
                last = remain[i];
            }else{
                cnt++;
            }
        }
        list.add(cnt);
        
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}