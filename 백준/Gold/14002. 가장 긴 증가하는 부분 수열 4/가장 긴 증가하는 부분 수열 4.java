import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer>[] dpList = new ArrayList[N];
        dpList[0] = new ArrayList<>();
        dpList[0].add(nums[0]);

        for(int i = 1; i < N; i++){
            int maxCnt = 0;
            int idx = -1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(maxCnt < dpList[j].size()){
                        maxCnt = dpList[j].size();
                        idx = j;
                    }
                }
            }
            if(idx == -1){
                dpList[i] = new ArrayList<>();
                dpList[i].add(nums[i]);
            }else{
                dpList[i] = new ArrayList<>();
                for(int k : dpList[idx]){
                    dpList[i].add(k);
                }
                dpList[i].add(nums[i]);
            }
        }

        int maxLength = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (dpList[i].size() > maxLength) {
                maxLength = dpList[i].size();
                maxIndex = i;
            }
        }
        
        System.out.println(dpList[maxIndex].size());
        for(int k : dpList[maxIndex]){
            System.out.print(k + " ");
        }
    }
}