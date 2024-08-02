import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Long> arr = new ArrayList<>();
            ArrayList<Long> tmp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                arr.add(Long.parseLong(st.nextToken()));
            }
            while (arr.size() > 2) {
                int tmpM = m / 2;
                for (int j = 0; j < tmpM; j++) {
                    tmp.add(arr.get(j) + arr.get(arr.size() - 1 - j));
                }
                if (m % 2 != 0) {
                    tmp.add(arr.get(m / 2) * 2);
                }
                arr.clear();
                arr.addAll(tmp); 
                m = (m + 1) / 2; 
                tmp.clear();
            }
            if (arr.get(0) > arr.get(1)) {
                System.out.println("Case #" + i + ": " + "Alice");
            } else {
                System.out.println("Case #" + i + ": " + "Bob");
            }
        }
    }
}