import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static Map<Integer, Character> directionMap = new HashMap<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] apple = br.readLine().split(" ");
            int y = Integer.parseInt(apple[0]) - 1;
            int x = Integer.parseInt(apple[1]) - 1;
            board[y][x] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] dir = br.readLine().split(" ");
            int time = Integer.parseInt(dir[0]);
            char turn = dir[1].charAt(0);
            directionMap.put(time, turn);
        }

        int result = simulate();
        System.out.println(result);
    }

    private static int simulate() {
        int time = 0;
        int dir = 0;
        Deque<int[]> snake = new ArrayDeque<>();
        snake.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;

        while (true) {
            time++;

            int[] head = snake.peekLast();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                return time;
            }
            
            if (board[nx][ny] == 1) { 
                board[nx][ny] = 0;
                snake.offerLast(new int[]{nx, ny});
                visited[nx][ny] = true;
            } else {
                snake.offerLast(new int[]{nx, ny});
                visited[nx][ny] = true;
                int[] tail = snake.pollFirst();
                visited[tail[0]][tail[1]] = false;
            }

            if (directionMap.containsKey(time)) {
                char c = directionMap.get(time);
                if (c == 'L') {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
        }
    }
}
