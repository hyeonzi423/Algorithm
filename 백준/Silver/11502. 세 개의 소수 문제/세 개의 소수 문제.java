import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isNotPrime = new boolean[1001];
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        sieve();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean found = false;

            for (int i = 0; i < primes.size(); i++) {
                for (int j = 0; j < primes.size(); j++) {
                    for (int k = 0; k < primes.size(); k++) {
                        int a = primes.get(i);
                        int b = primes.get(j);
                        int c = primes.get(k);
                        if (a + b + c == n) {
                            System.out.println(a + " " + b + " " + c);
                            found = true;
                            i = j = k = primes.size();
                        }
                    }
                }
            }

            if (!found) System.out.println(0);
        }
    }

    static void sieve() {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= 1000; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
                for (int j = i * 2; j <= 1000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}