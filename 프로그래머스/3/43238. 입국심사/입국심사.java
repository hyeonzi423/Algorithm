class Solution {
    public long solution(int n, int[] times) {
        long max = times[0];
        for(int t : times){
            max = Math.max(t, max);
        }
        
        long left = 1;
        long right = max * n;
        
        while(left < right){
            long mid = (left + right) / 2;
            long cnt = 0;
            for(int t : times){
                cnt += mid/t;
            }
            if(cnt >= n){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}