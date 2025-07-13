import java.io.*;
import java.util.*;

public class Main {
    static int N, K, max = 0;
    static String[] words;
    static boolean[] learned = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words[i] = word.substring(4, word.length() - 4); // anta~tica 제거
        }
        
        if (K < 5){
            System.out.println(0);
            return;
        }
        
        learned['a' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;
        
        dfs(0, 0);
        System.out.println(max);
    }
    
    public static void dfs(int index, int count){
        if(count == K - 5){
            int readable = 0;
            for(String word : words){
                boolean can = true;
                for(char ch : word.toCharArray()){
                    if(!learned[ch - 'a']){
                        can = false;
                        break;
                    }
                }
                if(can) readable++;
            }
            max = Math.max(max, readable);
            return;
        }
        
        for(int i = index; i < 26; i++){
            if(!learned[i]){
                learned[i] = true;
                dfs(i + 1, count + 1);
                learned[i] = false;
            }
        }
    }
}
