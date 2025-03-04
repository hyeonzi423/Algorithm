import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 0;
        int y = 0;
        int nx = 0;
        int ny = 0;      
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < dirs.length(); i++){
            char d = dirs.charAt(i);
            if(d == 'U' && nx > -5){
                nx = x - 1;
            }else if(d == 'D' && nx < 5){
                nx = x + 1;
            }else if(d == 'L' && ny > -5){
                ny = y - 1;
            }else if(d == 'R' && ny < 5){
                ny = y + 1;
            }
            if(x == nx && y == ny) continue;
            
            
            String check = x + "" + y + "" + nx + "" + ny;
            String reverse = nx + "" + ny + "" + x + "" + y;
            if(!set.contains(check) && !set.contains(reverse)){
                answer++;
                set.add(check);
                set.add(reverse);
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}