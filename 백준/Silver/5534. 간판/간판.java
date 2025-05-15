import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String name = br.readLine();
        int answer = 0;

        while (N-- > 0) {
            String line = br.readLine();
            int len = line.length();
            boolean found = false;

            for (int gap = 1; gap < len && !found; gap++) {
                for (int start = 0; start < len; start++) {
                    int idx = 0;
                    int pos = start;

                    while (pos < len && line.charAt(pos) == name.charAt(idx)) {
                        idx++;
                        if (idx == name.length()) {
                            answer++;
                            found = true;
                            break;
                        }
                        pos += gap;
                    }

                    if (found) break;
                }
            }
        }

        System.out.println(answer);
    }
}