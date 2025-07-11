import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (int i = 0; i < N - 1; i++) {
            String name = br.readLine();
            map.put(name, map.get(name) - 1);
        }

        for (String name : map.keySet()) {
            if (map.get(name) != 0) {
                System.out.println(name);
                break;
            }
        }
    }
}