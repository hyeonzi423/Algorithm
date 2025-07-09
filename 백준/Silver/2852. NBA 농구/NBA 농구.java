import java.util.*;
import java.io.*;

class Main {

    static int team1Score = 0, team2Score = 0;
    static int team1Time = 0, team2Time = 0;
    static int lastTime = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");
            int team = Integer.parseInt(str[0]);
            int current = timeToSeconds(str[1]);

            update(current);

            if(team == 1) team1Score++;
            else team2Score++;

            lastTime = current;
        }

        update(2880);
        
        System.out.println(secondsToTime(team1Time));
        System.out.println(secondsToTime(team2Time));
    }

    public static int timeToSeconds(String str){
        String[] now = str.split(":");
        int min = Integer.parseInt(now[0]);
        int sec = Integer.parseInt(now[1]);
        return min*60 + sec;
    }

    public static void update(int current){
        if(team1Score > team2Score){
            team1Time += (current - lastTime);
        }else if(team1Score < team2Score){
            team2Time += (current - lastTime);
        }
    }

    public static String secondsToTime(int totalSec) {
        int min = totalSec / 60;
        int sec = totalSec % 60;
        return String.format("%02d:%02d", min, sec);
    }
}