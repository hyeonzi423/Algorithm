import java.util.*;
import java.io.*;

class Main {

    static int N, studentNum;
    static char[][] map;
    static ArrayList<int[]> teachers;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        studentNum = 0;
        teachers = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'S'){
                    studentNum++;
                }else if(map[i][j] == 'T'){
                    teachers.add(new int[]{i, j});
                }
            }
        }

        combi(0);
        
        System.out.println("NO");
    }

    public static void combi(int depth){
        if(depth == 3){
            int ret = simul();
            if(ret == 0){
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 'X'){
                    map[i][j] = 'O';
                    combi(depth + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    public static int simul(){
        int cnt = 0;
        for(int[] t : teachers){
            for(int i = 0; i < 4; i++){
                int nx = t[0] + dx[i];
                int ny = t[1] + dy[i];
                while(true){
                    if(nx >= N || nx < 0 || ny >= N || ny < 0){
                        break;
                    }if(map[nx][ny] == 'O'){
                        break;
                    }if(map[nx][ny] == 'S'){
                        cnt++;
                    }
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }
        return cnt;
    }
}