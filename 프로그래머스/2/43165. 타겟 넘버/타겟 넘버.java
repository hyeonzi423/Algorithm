import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        
        for(int n : numbers){
            ArrayList<Integer> tmp = new ArrayList<>(); 
            for(int a : arr){
                tmp.add(a + n);
                tmp.add(a - n);
            }
            arr.clear();
            arr.addAll(tmp);
        }
        
        int answer = 0;
        for(int a : arr){
            if(a == target) answer++;
        }
        return answer;
    }
}