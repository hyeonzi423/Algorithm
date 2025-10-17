import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        int r = 0, b = 0;
        int i = 0, len = s.length();

        while (i < len) {
            char c = s.charAt(i);
            if (c == 'R') {
                r++;
                while (i < len && s.charAt(i) == 'R') i++;
            } else {
                b++;
                while (i < len && s.charAt(i) == 'B') i++;
            }
        }

        System.out.println(Math.min(r, b) + 1);
    }
}