import java.util.*;
import java.io.*;

public class Main {
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];
        if (m == 0) {
            System.out.print((int) Math.pow(10, n));
            System.exit(0);
        }
        int[] required = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer[] result = new Integer[n];
        dfs(0, n, required, result);
        System.out.print(count);
    }

    private static void dfs(int depth, int target, int[] required, Integer[] result) {
        if (depth == target) {
            for (int i = 0; i < required.length; i++) 
                if (!Arrays.asList(result).contains(required[i]))
                    return;
            count += 1;
            return;
        }
        for (int i = 0; i < 10; i++) {
            result[depth] = i;
            dfs(depth + 1, target, required, result);
        }
    }
}