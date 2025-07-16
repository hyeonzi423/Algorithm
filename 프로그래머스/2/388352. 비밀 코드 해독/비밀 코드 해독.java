import java.util.*;

class Solution {  
    public int[] code = new int[5];
    public int answer = 0;
    public int[][] q;
    public int[] ans;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.q = q;
        this.ans = ans;
        combi(1, 0, n);
        return answer;
    }
    
    public void combi(int start, int cnt, int n){
        if(cnt == 5){
            if(checkValid()) answer++;
            return;
        }
        
        for(int i = start; i <= n; i++){
            code[cnt] = i;
            combi(i + 1, cnt + 1, n);
        }
    }
    
    public boolean checkValid() {
        Set<Integer> codeSet = new HashSet<>();
        for (int c : code) codeSet.add(c);

        for (int i = 0; i < q.length; i++) {
            int match = 0;
            for (int num : q[i]) {
                if (codeSet.contains(num)) match++;
            }
            if (match != ans[i]) return false;
        }
        return true;
    }
}