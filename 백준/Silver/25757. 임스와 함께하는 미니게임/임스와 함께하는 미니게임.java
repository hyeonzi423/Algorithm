import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String c = st.nextToken();

        HashSet<String> s = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            s.add(str);
        }

        int cnt = s.size();
        if(c.equals("Y")){
            System.out.println(cnt);    
        }else if(c.equals("F")){
            System.out.println(cnt/2);   
        }else{
            System.out.println(cnt/3);   
        }
    }
}