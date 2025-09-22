import java.util.*;

class Solution {
    
    static Map<String, PriorityQueue<String>> route = new HashMap<>();
    static List<String> path = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        for(String[] t : tickets){
            PriorityQueue<String> tmp = route.getOrDefault(t[0], new PriorityQueue<>());
            tmp.offer(t[1]);
            route.put(t[0], tmp);
        }
        
        dfs("ICN");
        Collections.reverse(path);
        return path.toArray(new String[path.size()]);
    }
    
    public void dfs(String from){
        PriorityQueue<String> pq = route.get(from);
        while (pq != null && !pq.isEmpty()) {
            String to = pq.poll();
            dfs(to);
        }
        path.add(from);
    }
}