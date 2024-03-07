import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
  
public class Solution {
  
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
          
        for(int tc = 1; tc <= T; tc++) {
            long N = Long.parseLong(br.readLine());
              
            long left =1;
            long right = (long)Math.sqrt(N*2);  
            long res = -1;
              
            while(left <= right) {
                long mid = (left + right)/2;
                long value = mid*(mid+1)/2;
                if(value==N){
                    res = mid;
                    break;
                }else if(N>value) {
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
    }
  
}