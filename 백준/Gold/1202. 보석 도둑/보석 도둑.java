import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        long ans = 0;

        ArrayList<int[]> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            jewels.add(new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])});
        }

        Collections.sort(jewels, (j1, j2) -> Integer.compare(j1[0], j2[0]));

        PriorityQueue<Integer> bags = new PriorityQueue<>();
        for (int j = 0; j < K; j++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int index = 0;
        while (!bags.isEmpty()) {
            int bag = bags.poll();
            
            while (index < jewels.size() && jewels.get(index)[0] <= bag) {
                pq.add(jewels.get(index)[1]);
                index++;
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        System.out.println(ans);
    }
}