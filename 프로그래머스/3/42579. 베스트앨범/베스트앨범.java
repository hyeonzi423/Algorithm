import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> gCnt = new HashMap<>();
        HashMap<String, ArrayList<int[]>> mCnt = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            gCnt.put(genres[i], gCnt.getOrDefault(genres[i], 0) + plays[i]);
            ArrayList<int[]> tmp = mCnt.getOrDefault(genres[i], new ArrayList<>());
            tmp.add(new int[]{plays[i], i});
            mCnt.put(genres[i], tmp);
        }
        
        List<String> gen = new ArrayList<>(gCnt.keySet());
        Collections.sort(gen, (a, b) -> (gCnt.get(b) - gCnt.get(a)));
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < gen.size(); i++){
            ArrayList<int[]> tmp = mCnt.get(gen.get(i));
            tmp.sort((a, b) -> (b[0] - a[0]));
            for(int j = 0; j < Math.min(2, tmp.size()); j++){
                answer.add(tmp.get(j)[1]);
            }
        }
        
        int[] ans = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            ans[i] = answer.get(i);
        }
        return ans;
    } 
}