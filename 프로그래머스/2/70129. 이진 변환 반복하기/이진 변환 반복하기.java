class Solution {
    public int[] solution(String s) {
        int[] answer = new int[]{0, 0};
        
        while(!s.equals("1")){
            answer[0]++;
            int[] one = countOne(s);
            answer[1] += one[1];
            s = translate(one[0]);
        }
        return answer;
    }
    
    public int[] countOne(String s){
        int len = 0;
        for(int i = 0; i < s.length(); i++){
            len += s.charAt(i) == '1' ? 1 : 0;
        }
        return new int[]{len, s.length() - len};
    }
    
    public String translate(int s){
        StringBuilder sb = new StringBuilder();
        while(s > 1){
            int remain = s % 2;
            sb.append(remain);
            s /= 2;
        }
        if(s == 1) sb.append(1);
        return sb.reverse().toString();
    }
}