import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> treeMap = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int total = 0;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            treeMap.put(line, treeMap.getOrDefault(line, 0) + 1);
            total++;
        }

        StringBuilder sb = new StringBuilder();
        for (String tree : treeMap.keySet()) {
            int count = treeMap.get(tree);
            double percentage = (double) count / total * 100;
            sb.append(String.format("%s %.4f\n", tree, percentage));
        }

        System.out.print(sb);
    }
}
