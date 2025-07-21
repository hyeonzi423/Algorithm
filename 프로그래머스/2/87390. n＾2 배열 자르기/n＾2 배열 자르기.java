class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        for(int i = 0; i < (int)(right - left + 1); i++){
            long idx = i + left;
            int a = (int)(idx / n);
            int b = (int)(idx % n);
            answer[i] = Math.max(a, b) + 1;
        }
        return answer;
    }
}