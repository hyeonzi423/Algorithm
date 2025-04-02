import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);
        
        int frontA = 0;
        int backA = A.length - 1;
        int frontB = 0;
        int backB = B.length - 1;
        
        int answer = 0;
        for(int i = 0; i < A.length; i++){
            if(A[backA] < B[backB]){
                backA--;
                backB--;
                answer++;
            }else{
                backA--;
                frontB++;
            }
        }
        return answer;
    }
}