import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        int start = Integer.parseInt(nums[0]);
        int end = Integer.parseInt(nums[1]);
        int max = 100001;
        
        int[] visited = new int[max];
        int[] prev = new int[max];
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;

        while(!q.isEmpty()){
            int now = q.poll();
            
            if(now == end){
                break;
            }

            int[] next = new int[]{now - 1, now + 1, now * 2};
            for(int n : next){
                if(n >= 0 && n < max && visited[n] == 0){
                    q.offer(n);
                    visited[n] = visited[now] + 1;
                    prev[n] = now;
                }
            }
        }
        
        System.out.println(visited[end] - 1);

        Stack<Integer> stack = new Stack<>();
        for(int i = end; i != start; i = prev[i]){
            stack.push(i);
        }
        stack.push(start);

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}