import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, T;
    static char[][] map;
    static char[][] afterFirstExplosion;
    static char[][] afterSecondExplosion;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        if (T == 1) {
            printMap(map);
            return;
        }

        if (T % 2 == 0) {
            printFullBombMap();
            return;
        }

        afterFirstExplosion = simulateExplosion(map);
        afterSecondExplosion = simulateExplosion(afterFirstExplosion);

        if (T % 4 == 3) {
            printMap(afterFirstExplosion);
        } else {
            printMap(afterSecondExplosion);
        }
    }

    static char[][] simulateExplosion(char[][] currentMap) {
        char[][] newMap = new char[N][M];

        // 폭탄이 모두 설치된 상태로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = 'O';
            }
        }

        // 기존 폭탄이 터지는 과정
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (currentMap[i][j] == 'O') {
                    newMap[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            newMap[nx][ny] = '.';
                        }
                    }
                }
            }
        }

        return newMap;
    }

    static void printMap(char[][] mapToPrint) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(mapToPrint[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void printFullBombMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append('O');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
