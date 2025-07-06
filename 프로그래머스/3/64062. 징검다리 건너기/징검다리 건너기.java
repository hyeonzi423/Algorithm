class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 0;
        for (int s : stones) right = Math.max(right, s);
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(canCross(stones, k, mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }
    
    public boolean canCross(int[] stones, int k, int mid){
        int skip = 0;
        for(int stone : stones){
            if(stone < mid){
                skip++;
                if(skip >= k) return false;
            }else{
                skip = 0;
            }
        }
        return true;
    }
}