import java.io.*;
import java.util.*;

public class Main {

    static class Lecture implements Comparable<Lecture>{
        int start, end;

        Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o){
            if(this.end != o.end){
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        PriorityQueue<Lecture> pq = new PriorityQueue<>();   
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Lecture(s, e));
        }

        int ans = 0;
        int last = 0;
        while(!pq.isEmpty()){
            Lecture now = pq.poll();
            if(now.start >= last){
                ans++;
                last = now.end;
            }
        }
        System.out.println(ans);
    }
}

