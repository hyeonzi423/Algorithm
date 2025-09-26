import java.util.*;
class Solution {
    public class Word{
        String word;
        int cnt;
        
        public Word(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        boolean[] visited = new boolean[words.length];
        
        while(!q.isEmpty()){
            Word now = q.poll();
            if(now.word.equals(target)) {
                answer = now.cnt;
                break;
            }
            for(int i = 0; i < words.length; i++){
                if(visited[i]) continue;
                int cnt = 0;
                for(int j = 0; j < words[i].length(); j++){
                    if(words[i].charAt(j) == now.word.charAt(j)){
                        cnt++;
                    }
                }
                if(cnt == words[i].length() - 1){
                    visited[i] = true;
                    q.add(new Word(words[i], now.cnt + 1));
                }
            }
        }
        return answer;
    }
}