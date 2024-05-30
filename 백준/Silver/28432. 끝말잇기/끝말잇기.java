import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<String> list = new ArrayList<>();
        String left = null, right = null;
        int questionIndex = -1;
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            list.add(tmp);
            if (tmp.equals("?")) {
                questionIndex = i;
            }
        }
        
        if (questionIndex > 0) {
            left = list.get(questionIndex - 1);
        }
        if (questionIndex < N - 1) {
            right = list.get(questionIndex + 1);
        }
        
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String candidate = br.readLine();
            if (list.contains(candidate)) {
                continue; 
            }
            if ((left == null || candidate.charAt(0) == left.charAt(left.length() - 1)) &&
                (right == null || candidate.charAt(candidate.length() - 1) == right.charAt(0))) {
                System.out.println(candidate);
                return;
            }
        }
    }
}