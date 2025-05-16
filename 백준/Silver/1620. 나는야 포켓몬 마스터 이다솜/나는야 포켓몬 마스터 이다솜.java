import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        int N = Integer.parseInt(nums[0]);
        int M = Integer.parseInt(nums[1]);

        HashMap<String, Integer> strings = new HashMap<>();
        HashMap<Integer, String> numbers = new HashMap<>();
        
        for(int i = 1; i <= N; i++){
            String word = br.readLine();
            strings.put(word, i);
            numbers.put(i, word);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            String order = br.readLine();
            if(49 <= order.charAt(0) && order.charAt(0) <= 57) {
                sb.append(numbers.get(Integer.parseInt(order))).append("\n");
            }else{
                sb.append(strings.get(order)).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}