import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int R, C, ans;
    static char[][] map;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        ans = 0;
        dfs(0, 0, 1 << (map[0][0] - 'A'), 1);
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int visited, int depth) {
        ans = Math.max(ans, depth);

        if (ans == 26) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                continue;
            }

            int nextChar = map[nx][ny] - 'A';
            if ((visited & (1 << nextChar)) == 0) {
                dfs(nx, ny, visited | (1 << nextChar), depth + 1);
            }
        }
    }
}
