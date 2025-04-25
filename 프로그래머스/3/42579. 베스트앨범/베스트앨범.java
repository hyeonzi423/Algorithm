import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, ArrayList<int[]>> gMap = new HashMap<>();
        Map<String, Integer> cMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            ArrayList<int[]> ret = gMap.getOrDefault(genres[i], new ArrayList<>());
            ret.add(new int[]{i, plays[i]});
            gMap.put(genres[i], ret);
            
            int now = cMap.getOrDefault(genres[i], 0) + plays[i];
            cMap.put(genres[i], now);
        }
        
        List<String> sorted = new ArrayList<>(cMap.keySet());
        sorted.sort((g1, g2) -> cMap.get(g2) - cMap.get(g1));
        
        ArrayList<Integer> res = new ArrayList<>();
        for(String s : sorted){
            ArrayList<int[]> tmp = gMap.get(s);
            tmp.sort((t1, t2) -> {
                if(t1[1] != t2[1]) return t2[1] - t1[1];
                return t1[0] - t2[0];
            });
            for(int i = 0; i < Math.min(2, tmp.size()); i++){
                res.add(tmp.get(i)[0]);
            }
        }
        
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}