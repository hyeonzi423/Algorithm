class Solution {
    public long solution(int[] sequence) {
        int[] pulse1 = new int[sequence.length];
        int[] pulse2 = new int[sequence.length];
        
        for(int i = 0; i < sequence.length; i++){
            pulse1[i] = sequence[i] * (i % 2 == 0 ? 1 : -1);
            pulse2[i] = sequence[i] * (i % 2 == 0 ? -1 : 1);
        }
        
        
        long max1 = getMax(pulse1);
        long max2 = getMax(pulse2);
        return Math.max(max1, max2);
    }
    
    public long getMax(int[] pulse){
        long maxSum = pulse[0];
        long currentSum = pulse[0];
        
        for(int i = 1; i < pulse.length; i++){
            currentSum = Math.max(pulse[i], currentSum + pulse[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}