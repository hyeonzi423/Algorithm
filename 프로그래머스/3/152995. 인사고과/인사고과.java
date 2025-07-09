import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wh = scores[0];
        int whSum = wh[0] + wh[1];
        
        Arrays.sort(scores, (a, b) -> {
            if(a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1];
        });
        
        int maxScore = 0;
        int rank = 1;
        
        for(int[] score : scores){
            if(wh[0] < score[0] && wh[1] < score[1]){
                return -1;
            }
            if(score[1] >= maxScore){
                if(score[0] + score[1] > whSum){
                    rank++;
                }
                maxScore = Math.max(maxScore, score[1]);
            }
            
        }
        return rank;
    }
}