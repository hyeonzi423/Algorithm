import java.util.*;
import java.io.*;

class Main {
    public static class Team implements Comparable<Team> {
        int idx, f, s, t;

        public Team(int idx, int f, int s, int t){
            this.idx = idx;
            this.f = f;
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(Team o){
            if(this.f != o.f) return Integer.compare(o.f, this.f);
            if(this.s != o.s) return Integer.compare(o.s, this.s);
            return Integer.compare(o.t, this.t);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Team> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            pq.offer(new Team(idx, f, s, t));
        }

        int rank = 0, fir = 0, sec = 0, thr = 0, sta = 1;
         while (!pq.isEmpty()) {
            Team now = pq.poll();
            if(now.idx == Q){
                if(rank == 0){
                    System.out.println(++rank);
                    break;
                }else{
                    if(fir == now.f && sec == now.s && thr == now.t){
                        System.out.println(rank);
                        break;
                    }else{
                        System.out.println(++rank);
                        break;
                    }
                }
            }else{
                if(rank == 0){
                    fir = now.f;
                    sec = now.s;
                    thr = now.t;
                    rank++;
                }else{
                    if(fir == now.f && sec == now.s && thr == now.t){
                        sta++;
                        continue;
                    }else{
                        rank += sta;
                        sta = 1;
                        fir = now.f;
                        sec = now.s;
                        thr = now.t;
                    }
                }
            }
        }
    }
}