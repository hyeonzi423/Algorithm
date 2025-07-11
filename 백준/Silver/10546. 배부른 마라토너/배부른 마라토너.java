import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<String> participants = new ArrayList<>();
        for(int i = 0; i < N; i++){
            participants.add(br.readLine());
        }
        
        ArrayList<String> goals = new ArrayList<>();
        for(int i = 0; i < N-1; i++){
            goals.add(br.readLine());
        }

        Collections.sort(participants);
        Collections.sort(goals);

        boolean find = false;
        for(int i = 0; i < N-1; i++){
            if(!participants.get(i).equals(goals.get(i))){
                System.out.println(participants.get(i));
                find = true;
                break;
            }
        }

        if(!find) System.out.println(participants.get(N-1));
    }
}