import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        Arrays.sort(data, (a, b) -> {
            if(a[col-1] == b[col-1]){
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(a[col-1], b[col-1]);
        });
        
        int answer = 0;
        for(int i = row_begin - 1; i < row_end; i++){
            int sum = 0;
            for(int num : data[i]){
                sum += num % (i + 1);
            }
            answer ^= sum;
        }
        
        return answer;
    }
}