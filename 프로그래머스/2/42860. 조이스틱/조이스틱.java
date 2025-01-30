class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        int move = n - 1;
        
        for(int i = 0; i < n; i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int next = i + 1;
            while(next < n && name.charAt(next) == 'A'){
                next++;
            }
            
            move = Math.min(move, i + n - next + Math.min(i, n - next));
        }
        return answer + move;
    }
}