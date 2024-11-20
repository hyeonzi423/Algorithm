import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        HashSet S = new HashSet();
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }
            if(order.equals("add")){
                S.add(num);
            }else if(order.equals("remove")){
                S.remove(num);
            }else if(order.equals("check")){
                sb.append(S.contains(num) ? 1 : 0).append("\n");
            } else if(order.equals("toggle")){
                if(S.contains(num)){
                    S.remove(num);
                }else{
                    S.add(num);
                }
            } else if(order.equals("empty")){
                S = new HashSet();
            } else{
                S = new HashSet();
                for(int j = 1; j <= 20; j++){
                    S.add(j);
                }
            }
        }
        System.out.println(sb);
    }
}