import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            String ans = "YES";
            int left = 0;
            
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '('){
                    left++;    
                }else{
                    if(left == 0){
                        ans = "NO";
                        break;
                    }else{
                        left--;
                    }
                }
            }
            if(left > 0) ans = "NO";
            
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}