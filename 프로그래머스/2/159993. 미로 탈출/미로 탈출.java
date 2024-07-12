import java.util.*;
import java.awt.Point;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int N = maps.length;
        int M = maps[0].length();
        Point start = new Point(0, 0);
        Point end = new Point(0, 0);
        Point lever = new Point(0, 0);
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Character[][] map = new Character[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                Character tmp = maps[i].charAt(j);
                map[i][j] = tmp;
                if(tmp == 'S'){
                    start = new Point(i, j);
                } else if(tmp == 'E'){
                    end = new Point(i, j);
                } else if(tmp == 'L'){
                    lever = new Point(i, j);
                }
            }
        }
        
        boolean flag = false;
        int visited[][] = new int[N][M];
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x == lever.x && now.y == lever.y){
                flag = true;
                answer += visited[now.x][now.y];
                break;
            }
            for(int k = 0; k < 4; k++){
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if(0 > nx || nx >= N || 0 > ny || ny >= M){
                    continue;
                }if(visited[nx][ny] != 0 || map[nx][ny] == 'X'){
                    continue;
                }
                visited[nx][ny] = visited[now.x][now.y] + 1;
                q.add(new Point(nx, ny));
            }
        }
        
        if(!flag){
            return -1;
        }
        else{
            System.out.println(answer);
            flag = false;
            visited = new int[N][M];
            q = new LinkedList<>();
            q.add(lever);
            while(!q.isEmpty()){
                Point now = q.poll();
                if(now.x == end.x && now.y == end.y){
                    flag = true;
                    answer += visited[now.x][now.y];
                    break;
                }
                for(int k = 0; k < 4; k++){
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];
                    if(0 > nx || nx >= N || 0 > ny || ny >= M){
                        continue;
                    }if(visited[nx][ny] != 0 || map[nx][ny] == 'X'){
                        continue;
                    }
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
            if(!flag){
                return -1;
            }else{
                for(int i = 0; i < N; i++){
                    for(int j = 0; j < M; j++){
                        System.out.print(visited[i][j] + " ");
                    }
                    System.out.println();
                }
                return answer;
            }
        }
    }
}