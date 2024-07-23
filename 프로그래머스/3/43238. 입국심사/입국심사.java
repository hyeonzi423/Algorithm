class Solution {
    public long solution(int n, int[] times) {
        long max = times[0];
        for(int t : times){
            max = Math.max(t, max);
        }
        long left = 1, right = max*n;
        while(left < right){
            long people = 0;
            long mid = (left + right) / 2;
            for(int t : times){
                people += mid / t;
            }
            if(people >= n){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}