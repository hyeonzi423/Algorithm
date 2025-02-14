import java.util.*;
import java.io.*;

class Main {

    static int N;
    static char[][] map;
    static List<int[]> teachers, spaces;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        teachers = new ArrayList<>();
        spaces = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T') {
                    teachers.add(new int[]{i, j});
                } else if (map[i][j] == 'X') {
                    spaces.add(new int[]{i, j});
                }
            }
        }

        placeObstacles(0, 0);

        System.out.println("NO");
    }

    public static void placeObstacles(int depth, int start) {
        if (depth == 3) {
            if (simulate()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        
        for (int i = start; i < spaces.size(); i++) {
            int[] pos = spaces.get(i);
            map[pos[0]][pos[1]] = 'O';
            placeObstacles(depth + 1, i + 1);
            map[pos[0]][pos[1]] = 'X';
        }
    }

    public static boolean simulate() {
        for (int[] t : teachers) {
            for (int d = 0; d < 4; d++) {
                int nx = t[0] + dx[d];
                int ny = t[1] + dy[d];
                while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 'O') break;
                    if (map[nx][ny] == 'S') return false;
                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }
        return true;
    }
}