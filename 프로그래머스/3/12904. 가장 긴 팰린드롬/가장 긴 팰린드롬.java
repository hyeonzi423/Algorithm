class Solution{
    public int solution(String s){
        int max = 1;
        int len = s.length();
        for(int i = 0; i < len; i++){
            max = Math.max(max, expand(i, i, s));
            max = Math.max(max, expand(i, i+1, s));
        }
        return max;
    }
    
    public int expand(int left, int right, String s){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}