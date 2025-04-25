import java.util.*;
class Solution {
    static int answer = 0;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        permu(numbers, "");
        for(int s : set){
            if(isPrime(s)){
                answer++;
            }
        }
        return answer;
    }
    
    public void permu(String numbers, String current){
        if(current.length() != 0){
            set.add(Integer.parseInt(current));
        }
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                permu(numbers, current + numbers.charAt(i));
                visited[i] = false;
            }   
        }
    }
    
    public boolean isPrime(int val){
        if (val < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(val); i++){
            if(val % i == 0){
                return false;
            }
        }
        return true;
    }
}