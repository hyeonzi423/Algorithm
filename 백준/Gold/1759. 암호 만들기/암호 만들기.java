import java.util.*;
import java.io.*;

class Main {

    static int L, C;
    static char[] alpha, secretCode;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[C];
        secretCode = new char[L];
        sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha);
        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int start, int count){
        if(count == L){
            int a = 0, b = 0;
            for(char tmp : secretCode) {
				if(tmp == 'a' || tmp == 'e' || tmp == 'i' ||tmp == 'o' || tmp == 'u'){
                    a++;
                }else{
                    b++;
                }
            }
            if(a >= 1 && b >= 2){
                sb.append(new String(secretCode)).append("\n");
            }
            return;
        }

        for(int i = start; i < C; i++){
            secretCode[count] = alpha[i];
            dfs(i + 1, count + 1);
        }
    }
}