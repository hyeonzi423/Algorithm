import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
            
        boolean[] sleeping = new boolean[N + 3];   // 졸고 있는 학생 여부
        boolean[] attended = new boolean[N + 3];   // 출석 여부
        int[] prefix = new int[N + 3]; 

        // 졸고 있는 학생 번호 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            sleeping[Integer.parseInt(st.nextToken())] = true;
        }

        // 출석 코드 받은 학생 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; i++){
            int sender = Integer.parseInt(st.nextToken());
            if(sleeping[sender]) continue;

            for(int j = sender; j <= N + 2; j += sender){
                if(!sleeping[j]){
                    attended[j] = true;
                }
            }
        }

        // 누적합 배열
        for(int i = 3; i <= N + 2; i++){
            prefix[i] = prefix[i-1] + (attended[i] ? 0 : 1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(prefix[E] - prefix[S - 1]).append('\n');
        }
        
        System.out.print(sb);
    }
}