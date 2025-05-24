import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine().trim();

        int[] cnt = new int[26];
        for (char c : name.toCharArray()) {
            cnt[c - 'A']++;
        }

        int oddCount = 0;
        int oddIdx = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) {
                oddCount++;
                oddIdx = i;  // 홀수 개인 문자의 인덱스 기억
            }
        }

        // 팰린드롬이 불가능한 경우
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder half = new StringBuilder();
        // 절반 앞 부분 구성 (사전순)
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i] / 2; j++) {
                half.append((char) ('A' + i));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(half);
        // 가운데 문자 추가 (존재할 경우)
        if (oddCount == 1) {
            result.append((char) ('A' + oddIdx));
        }
        // 뒤쪽 절반은 앞절반을 뒤집은 값
        result.append(half.reverse());

        System.out.println(result.toString());
    }
}