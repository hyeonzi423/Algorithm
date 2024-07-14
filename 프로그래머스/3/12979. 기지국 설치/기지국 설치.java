class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0, part;

        for(int i = 0; i <= stations.length; i++){
            if(i == 0){
                part = stations[0] - w - 1;
            }else if(i == stations.length){
                part = n - stations[i - 1] - w;
            }else{
                part = stations[i] - stations[i-1] - 2*w - 1;
            }
            
            if(part >= 0){
                answer += part / (2*w + 1);
                if(part % (2*w + 1) != 0){
                    answer++;
                }
            }
        }
        return answer;
    }
}