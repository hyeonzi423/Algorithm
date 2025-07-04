import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
    
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> lis = new ArrayList<>();
        for(int num : arr){
            if(lis.isEmpty() || lis.get(lis.size() - 1) < num){
                lis.add(num);
            }else{
                int left = 0;
                int right = lis.size() - 1;
                while(left < right){
                    int mid = (left + right) / 2;
                    if(lis.get(mid) >= num){
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                lis.set(right, num);
            }
        }

        System.out.println(lis.size());
    }
}