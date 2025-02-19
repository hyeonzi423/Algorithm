import java.util.*;
import java.io.*;

class Main {

    static int N, M;
    static int[][] map, groupMap, ansMap;
    static ArrayList<Integer> zeroGroupCount;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        groupMap = new int[N][M];
        ansMap = new int[N][M]; 
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        zeroGroupCount = new ArrayList<>();
        bfs();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){
                    int cnt = 1;
                    HashSet<Integer> set = new HashSet<>();
                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(!inRange(nx, ny)){
                            continue;
                        }if(set.contains(groupMap[nx][ny])){
                            continue;
                        }if(map[nx][ny] == 1){
                            continue;
                        }
                        set.add(groupMap[nx][ny]);
                        cnt += zeroGroupCount.get(groupMap[nx][ny] - 1);
                    }
                    ansMap[i][j] = cnt % 10;
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(ansMap[i][j]);
            }
            System.out.println();
        }
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int idx = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    q.clear();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    groupMap[i][j] = ++idx;
                    int tmpCnt = 1;

                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if(!inRange(nx, ny)){
                                continue;
                            }if(visited[nx][ny] || map[nx][ny] == 1){
                                continue;
                            }
                            groupMap[nx][ny] = idx;
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny});
                            tmpCnt++;
                        }
                    }
                    zeroGroupCount.add(tmpCnt);
                }
            }
        }
    }

    public static boolean inRange(int x, int y){
        return 0 <= x  && x < N && 0 <= y && y < M;
    }
}