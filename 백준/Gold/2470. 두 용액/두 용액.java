import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] value = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            value[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(value);
        
        int diff = Integer.MAX_VALUE;
        int left = 0;
        int right = N-1;
        int ans1 = -1;
        int ans2 = -1;
        
        while (left < right){
            if(diff > Math.abs(value[left] + value[right])){
                diff = Math.abs(value[left] + value[right]);
                ans1 = value[left];
                ans2 = value[right];
            }
            
            if(value[left] + value[right] == 0){
                break;
            }else if(value[left] + value[right] < 0){
                left++;
            }else{
                right--;
            }
            
        }
        
        System.out.println(ans1 + " " + ans2);
    }
}