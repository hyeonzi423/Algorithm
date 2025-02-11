import java.util.*;
import java.io.*;

class Main {

    public static class Number{
        String N;
        int cnt;

        Number(String N, int cnt){
            this.N = N;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        String N = num[0];
        int K = Integer.parseInt(num[1]);
        int size = num[0].length();
        String max = "";
        
        Queue<Number> q = new LinkedList<>();
        q.add(new Number(N, 0));
        
        HashSet<String>[] visited = new HashSet[K + 1];
        for (int i = 0; i <= K; i++) {
            visited[i] = new HashSet<>();
        }
        visited[0].add(N);

        while(!q.isEmpty()){
            Number now = q.poll();
            
            if(now.cnt == K){
                if(max.compareTo(now.N) < 0){
                    max = now.N;
                }
            }

            if(now.cnt > K){
                break;
            }
            
            for(int i = 0; i < size; i++){
                for(int j = i + 1; j < size; j++){
                    if(i == j || (i == 0 && now.N.charAt(j) == '0')){
                        continue;
                    }

                    char[] charArray = now.N.toCharArray();
                    char temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
            
                    String result = new String(charArray);
                    if (now.cnt + 1 <= K && !visited[now.cnt + 1].contains(result)) {
                        visited[now.cnt + 1].add(result);
                        q.add(new Number(result, now.cnt + 1));
                    }
                }
            }
        }

        System.out.println(max.length() == 0 ? -1 : max);
    }
}