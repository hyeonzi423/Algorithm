class Solution {
    public int solution(int[][] sizes) {
        int h = 0, w = 0;
        for(int[] s : sizes){
            h = Math.max(h, Math.max(s[0], s[1]));
            w = Math.max(w, Math.min(s[0], s[1]));
        }
        return h * w;
    }
}