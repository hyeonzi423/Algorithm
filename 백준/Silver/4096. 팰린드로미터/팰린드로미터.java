import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
            s = s.trim();
            if (s.equals("0")) break;

            String p = smallestPalindromeGE(s);
            BigInteger ans = new BigInteger(p).subtract(new BigInteger(s));
            out.append(ans.toString()).append('\n');
        }
        System.out.print(out.toString());
    }

    // s 이상인 가장 작은 팰린드롬 생성
    private static String smallestPalindromeGE(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        char[] p = a.clone();

        for (int i = 0; i < n / 2; i++) {
            p[n - 1 - i] = p[i];
        }

        String mirrored = new String(p);
        if (mirrored.compareTo(s) >= 0) return mirrored;

        // 중앙에서 +1 (캐리 전파) 하면서 다시 미러링
        int i = (n - 1) / 2;
        int j = n / 2;
        int carry = 1;
        while (i >= 0 && carry > 0) {
            int d = (p[i] - '0') + 1;
            p[i] = (char) ('0' + (d % 10));
            p[j] = p[i];     // 대칭 반영
            carry = d / 10;
            i--; j++;
        }

        if (carry > 0) {
            StringBuilder sb = new StringBuilder(n + 1);
            sb.append('1');
            for (int k = 0; k < n - 1; k++) sb.append('0');
            sb.append('1');
            return sb.toString();
        }
        return new String(p);
    }
}