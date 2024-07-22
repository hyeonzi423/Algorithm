import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 0; i < N; i++){
            String tmp = br.readLine();
            if(tmp.length() %2 == 1) continue;
            Stack<Character> s = new Stack<>();
            s.push(tmp.charAt(0));
            for(int j = 1; j < tmp.length(); j++){
                if(s.size() > 0 && s.peek() == tmp.charAt(j)){
                    s.pop();
                }else{
                    s.push(tmp.charAt(j));
                }
            }
            if(s.isEmpty()) cnt++;
        }
        System.out.println(cnt);
    }
}