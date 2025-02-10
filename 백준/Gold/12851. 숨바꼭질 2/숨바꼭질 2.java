import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        
        int minTime = Integer.MAX_VALUE;
        int cnt = 0;

        q.add(new int[]{start, 0});
        visited[start] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int position = now[0];
            int time = now[1];

            if (time > minTime) break;

            if (position == end) {
                if (time < minTime) {
                    minTime = time;
                    cnt = 1;
                } else if (time == minTime) {
                    cnt++;
                }
            }

            int[] nextPositions = {position - 1, position + 1, position * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000) {
                    if (visited[next] >= time + 1) {
                        visited[next] = time + 1;
                        q.offer(new int[]{next, time + 1});
                    }
                }
            }
        }

        System.out.println(minTime);
        System.out.println(cnt);
    }
}