class Solution {
    public int[] solution(int n, int s) {
        if(n > s){
            return new int[]{-1};
        }
        int a = s / n;
        int b = s % n;
        
        int[] ans = new int[n];
        for(int i = n - 1; i >= 0; i--){
            ans[i] = a;
            if(b > 0){
                ans[i] += 1;
                b--;
            }
        }
        return ans;
    }
}