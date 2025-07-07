import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        int down = N;
        for (int col = 0; col < M; col++) {
            int maxX = -1;
        
            for (int row = 0; row < N; row++) {
                if (map[row][col] == 'X') {
                    maxX = row;
                } else if (map[row][col] == '#') {
                    if(maxX == -1) continue;
                    down = Math.min(down, row - maxX - 1);
                    break;
                }
            }
        }

        List<int[]> stars = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'X') {
                    stars.add(new int[]{i, j});
                }
            }
        }

        for (int[] s : stars) {
            map[s[0]][s[1]] = '.';
        }

        for (int[] s : stars) {
            int newRow = s[0] + down;
            if (newRow < N) {
                map[newRow][s[1]] = 'X';
            }
        }
  
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map[i]).append('\n');
        }
        System.out.print(sb);
    }

}