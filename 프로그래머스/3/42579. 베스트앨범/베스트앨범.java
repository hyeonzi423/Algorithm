import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, ArrayList<int[]>> g = new HashMap<>(); // 장르별 인덱스와 플레이 수
        HashMap<String, Integer> p = new HashMap<>(); // 장르별 총 합
        
        for(int i = 0; i < genres.length; i++){
            ArrayList<int[]> arr = g.getOrDefault(genres[i], new ArrayList<>());
            arr.add(new int[]{plays[i], i});
            g.put(genres[i], arr);
            
            p.put(genres[i], p.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> sortedGenres = new ArrayList<>(p.keySet());
        sortedGenres.sort((g1, g2) -> p.get(g2) - p.get(g1));
        
        ArrayList<Integer> res = new ArrayList<>();
        for(String genre : sortedGenres){
            ArrayList<int[]> songs = g.get(genre);
            songs.sort((s1, s2) -> s2[0] - s1[0]);
        
            for(int i = 0; i < Math.min(2, songs.size()); i++){
                res.add(songs.get(i)[1]);
            }
        }
        
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}