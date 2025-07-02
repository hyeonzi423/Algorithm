import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // start
            meetings[i][1] = Integer.parseInt(st.nextToken()); // end
        }

        // 1. 시작 시간 기준 정렬
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // 2. 끝나는 시간만 저장하는 우선순위 큐
        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.add(meetings[0][1]); // 첫 회의 끝나는 시간

        for(int i = 1; i < N; i++){
            if(room.peek() <= meetings[i][0]){
                room.poll(); // 가장 먼저 끝나는 회의실을 재사용
            }
            room.add(meetings[i][1]); // 새 회의 배정
        }

        System.out.println(room.size()); // 큐의 크기 = 회의실 개수
    }
}