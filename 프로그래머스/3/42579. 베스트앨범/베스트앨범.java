import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, ArrayList<Integer>> list = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            String g = genres[i];
            if(map.containsKey(g)){
                map.put(g, map.get(g) + plays[i]);
                list.get(g).add(i);
            }else{
                map.put(g, plays[i]);
                list.put(g, new ArrayList<>());
                list.get(g).add(i);
            }
        }
        
        List<Map.Entry<String, Integer>> mapList = new ArrayList<>(map.entrySet());
        mapList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        for(Map.Entry<String, Integer> m : mapList){
            ArrayList<Integer> tmp = list.get(m.getKey());
            tmp.sort((s1, s2) -> plays[s2] - plays[s1]);
            answer.add(tmp.get(0));
            if(tmp.size() > 1){
                answer.add(tmp.get(1));
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}