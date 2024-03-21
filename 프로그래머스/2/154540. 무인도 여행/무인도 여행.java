import java.util.*;

class Solution {
    static boolean visited[][];
    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> ans;
    
    static class Point{
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }   
    }
    
    public int[] solution(String[] maps) {
        int[] answer;
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        ans = new ArrayList<>();
        
        map = new char[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 'X' && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }
        
        if (ans.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            Collections.sort(ans);
            answer = new int[ans.size()];
            for(int i = 0; i < ans.size(); i++){
                answer[i] = ans.get(i);
            }
        }
        return answer;
    }
    
    public static void bfs(int x, int y){
        visited[x][y] = true;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        int ret = map[x][y] - '0';
        
        while(!q.isEmpty()){
            Point now = q.poll();
            for(int k = 0; k < 4; k++){
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if(0 <= nx && nx < N && 0 <= ny && ny < M){
                    if(!visited[nx][ny] && map[nx][ny] !='X'){
                        ret += map[nx][ny] - '0';
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
        ans.add(ret);
    }
}