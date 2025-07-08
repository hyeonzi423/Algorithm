import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            char[] word = br.readLine().toCharArray();
            if(next(word)){
                System.out.println(new String(word));
            }else{
                System.out.println(new String(word));
            }    
        }
    }

    public static boolean next(char[] arr){
        int i = arr.length - 1;
        while(i > 0 && arr[i-1] >= arr[i]){
            i--;
        }

        if(i <= 0) return false;

        int j = arr.length - 1;
        while(arr[i-1] >= arr[j]){
            j--;
        }

        swap(arr, i-1, j);

        int k = arr.length - 1;
        while(i < k){
            swap(arr, i, k);
            i++;
            k--;
        }

        return true;
    }

    private static void swap(char[] arr, int a, int b){
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}