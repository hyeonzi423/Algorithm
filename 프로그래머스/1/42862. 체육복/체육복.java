import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] count = new int[n+1];
        
        for(int l : lost){
            count[l]--;
        }
        for(int r : reserve){
            count[r]++;
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (count[i] >= 0) {
                answer++;
            } else {
                if (i > 1 && count[i - 1] >= 1) {
                    count[i - 1]--;
                    answer++;
                } else if (i < n && count[i + 1] >= 1) {
                    count[i + 1]--;
                    answer++;
                }
            }
        }
        return answer;
    }
}