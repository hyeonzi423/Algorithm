import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int[] nums;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            boolean[] cycleCheck = new boolean[N + 1];
            if (dfs(i, i, cycleCheck)) {
                result.add(i);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    public static boolean dfs(int start, int current, boolean[] cycleCheck) {
        if (cycleCheck[current]) {
            return start == current;
        }

        cycleCheck[current] = true;
        return dfs(start, nums[current], cycleCheck);
    }
}