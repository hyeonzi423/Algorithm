import java.util.*;
import java.io.*;

class Main {

    static int N;
    static boolean found = false; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs("");
        
    }

    public static void dfs(String str){
        if(found) return;
        
        if (str.length() == N) {
            System.out.println(str);
            found = true;
            return;
        }

        for (int i = 1; i <= 3; i++){
            String next = str + i;
            if (isGood(next)) {
                dfs(next);
            }
        }
    }

    public static boolean isGood(String s){
        int len = s.length();

        for (int i = 1; i <= len / 2; i++) {
            String left = s.substring(len - i * 2, len - i);
            String right = s.substring(len - i);
            if (left.equals(right)) return false;
        }
        return true;
    }
}