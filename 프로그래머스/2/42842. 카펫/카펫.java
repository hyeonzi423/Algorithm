class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int remain = (brown - 4)/2;
        for(int i = 1; i < remain; i++){
            int o = remain - i;
            if(o*i == yellow){
                return new int[]{o+2, i+2};
            }
        }
        return answer;
    }
}