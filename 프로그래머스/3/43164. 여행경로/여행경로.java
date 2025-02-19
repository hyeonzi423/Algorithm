import java.util.*;
class Solution {
    
    static Map<String, PriorityQueue<String>> move;
    static List<String> route;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        move = new HashMap<>();
        for(String[] t : tickets){
            move.putIfAbsent(t[0], new PriorityQueue<>());
            move.get(t[0]).add(t[1]);
        }
        
        route = new LinkedList<>();
        dfs("ICN");
        
        return route.toArray(new String[0]);
    }
    
    public static void dfs(String airport){
        while(move.containsKey(airport) && !move.get(airport).isEmpty()){
            dfs(move.get(airport).poll());
        }
        route.add(0, airport);
    }
}