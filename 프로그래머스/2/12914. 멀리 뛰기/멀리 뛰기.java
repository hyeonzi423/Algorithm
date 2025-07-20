class Solution {
    public long solution(int n) {
        long f1 = 1, f2 = 1, f3 = 1;
        if(n < 2){
            return 1;
        }
        for(int i = 0; i < n - 1; i++){
            f3 = (f1 + f2) % 1234567;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}