class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int right = 0, left = 1000000, mid = 0;
        for(int i = 0; i < diffs.length; i++){
            right = Math.max(right, diffs[i]);
            left = Math.min(left, diffs[i]);
        }
        
        while(left < right){
            mid = (left + right)/2;
            long ret = cal(mid, diffs, times);
            if(ret <= limit){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        
        return left;
    }
    
    public long cal(long level, int[] diffs, int[] times){
        long sum = 0;
        for(int i = 0; i < diffs.length; i++){
            if(diffs[i] <= level){
                sum += times[i];
            }else{
                sum += (times[i-1] + times[i]) * (diffs[i] - level) + times[i];
            }
        }
        return sum;
    }
}