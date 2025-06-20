import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - A.length(); i++) {
            int diff = 0;

            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(i + j)) {
                    diff++;
                }
            }

            minDiff = Math.min(minDiff, diff);
        }

        System.out.println(minDiff);
    }
}