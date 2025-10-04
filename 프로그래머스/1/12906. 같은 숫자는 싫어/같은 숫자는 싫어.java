import java.util.*;
public class Solution {
    public int[] solution(int [] arrNum) {
        ArrayList<Integer> arr = new ArrayList<>();
        int flag = -1;
        for(int a : arrNum){
            if(flag != a){
                arr.add(a);
                flag = a;
            }
        }

        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}