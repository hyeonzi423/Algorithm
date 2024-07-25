import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int np1 = 5, np2 = 8, np3 = 10;
        int[] cnt = new int[3];
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == p1[i%np1]){
                cnt[0]++;
            }if(answers[i] == p2[i%np2]){
                cnt[1]++;
            }if(answers[i] == p3[i%np3]){
                cnt[2]++;
            }
        }
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(max == cnt[i]){
                ans.add(i+1);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}