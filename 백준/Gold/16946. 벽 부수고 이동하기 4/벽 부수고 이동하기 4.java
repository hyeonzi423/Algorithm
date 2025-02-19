import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map, groupId, result;
    static int[] groupSize;
    static boolean[][] visited;
    static int groupCount = 0;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        groupId = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];
        List<Integer> groupSizes = new ArrayList<>();
        groupSizes.add(0);

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    groupSizes.add(bfs(i, j, groupCount + 1));
                    groupCount++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    result[i][j] = getGroupSum(i, j, groupSizes);
                }
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static int bfs(int x, int y, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        groupId[x][y] = id;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        groupId[nx][ny] = id;
                        queue.add(new int[]{nx, ny});
                        size++;
                    }
                }
            }
        }

        return size;
    }

    static int getGroupSum(int x, int y, List<Integer> groupSizes) {
        Set<Integer> uniqueGroups = new HashSet<>();
        int sum = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] == 0) {
                    int gid = groupId[nx][ny];
                    if (!uniqueGroups.contains(gid)) {
                        uniqueGroups.add(gid);
                        sum += groupSizes.get(gid);
                    }
                }
            }
        }

        return sum % 10;
    }
}