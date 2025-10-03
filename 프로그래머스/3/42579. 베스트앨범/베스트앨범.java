import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> pMap = new HashMap<>();
        HashMap<String, ArrayList<int[]>> gMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            pMap.put(genres[i], pMap.getOrDefault(genres[i], 0) + plays[i]);
            ArrayList<int[]> tmp = gMap.getOrDefault(genres[i], new ArrayList<>());
            tmp.add(new int[]{plays[i], i});
            gMap.put(genres[i], tmp);
        }
        
        ArrayList<String> gen = new ArrayList<>(pMap.keySet());
        Collections.sort(gen, (a, b) -> (pMap.get(b) - pMap.get(a)));
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(String g : gen){
            ArrayList<int[]> songs = gMap.get(g);
            Collections.sort(songs, (a, b) -> {
                if(a[0] != b[0]){
                    return b[0] - a[0];
                }return a[1] - b[1];
            });
            for(int i = 0; i < Math.min(2, songs.size()); i++){
                ans.add(songs.get(i)[1]);
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}