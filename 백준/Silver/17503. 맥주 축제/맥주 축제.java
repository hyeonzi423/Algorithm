import java.io.*;
import java.util.*;

class Beer implements Comparable<Beer> {
    int prefer, alcohol;

    public Beer(int prefer, int alcohol) {
        this.prefer = prefer;
        this.alcohol = alcohol;
    }

    @Override
    public int compareTo(Beer o) {
        return this.alcohol - o.alcohol;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Beer[] beers = new Beer[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 선호도
            int c = Integer.parseInt(st.nextToken()); // 도수
            beers[i] = new Beer(v, c);
        }

        Arrays.sort(beers);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 선호도를 저장할 최소 힙
        long sum = 0;
        int answer = -1;

        for (int i = 0; i < K; i++) {
            pq.offer(beers[i].prefer);
            sum += beers[i].prefer;

            if (pq.size() > N) {
                sum -= pq.poll(); // 선호도 낮은 맥주 제거
            }

            if (pq.size() == N && sum >= M) {
                answer = beers[i].alcohol;
                break; // 가장 작은 도수에서 조건을 만족하면 종료
            }
        }

        System.out.println(answer);
    }
}
