import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        int cnt = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++){
            setA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++){
            setB.add(Integer.parseInt(st.nextToken()));
        }
        
        for (int num: setA){
            if (!setB.contains(num)){
                cnt += 1;
            }
        }
        for (int num: setB){
            if (!setA.contains(num)){
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}