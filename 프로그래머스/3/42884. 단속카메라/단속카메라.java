import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        int answer = 1;
        int last = routes[0][1];
        
        for(int i = 1; i < routes.length; i++){
            if(last < routes[i][0]){
                last = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}