import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        int[] answer = new int[n];
        
        for(int i = 1; i <= n; i++){
            numbers.add(i);
        }
        
        k--;
        
        for(int i = 0; i < n; i++){
            long fact = factorial(n - 1 - i);
            int idx = (int)(k / fact);
            answer[i] = numbers.get(idx);
            numbers.remove(idx);
            k %= fact;
        }
        
        return answer;
    }
    
    public long factorial(int num){
        long result = 1;
        for(int i = 2; i <= num; i++){
            result *= i;
        }
        return result;
    }
}