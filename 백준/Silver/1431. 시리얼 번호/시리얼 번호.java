import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static int N;
    public static PriorityQueue<Word> words;

    public static class Word implements Comparable<Word> {
        String w;
        int len, number;

        public Word(String w) {
            this.w = w;
            this.len = w.length();
            this.number = extractNumber(w);
        }

        private int extractNumber(String w) {
            int hap = 0;
            for (char c : w.toCharArray()) {
                if (Character.isDigit(c)) {
                    hap += (c - '0'); // 문자에서 숫자 값을 추출하여 합산
                }
            }
            return hap;
        }

        @Override
        public int compareTo(Word o) {
            if (this.len != o.len) {
                return this.len - o.len;
            }
            if (this.number != o.number) {
                return this.number - o.number;
            }
            return compareStrings(this.w, o.w);
        }

        private int compareStrings(String s1, String s2) {
        	for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    if (Character.isDigit(c1) && Character.isDigit(c2)) {
                        return c1 - c2; // 둘 다 숫자인 경우
                    } else if (Character.isDigit(c1)) {
                        return -1; // 숫자가 알파벳보다 앞에 와야 함
                    } else if (Character.isDigit(c2)) {
                        return 1; // 알파벳이 숫자보다 뒤에 와야 함
                    } else {
                        return c1 - c2; // 둘 다 알파벳인 경우
                    }
                }
            }
        	return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        words = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            words.add(new Word(tmp));
        }

        while (!words.isEmpty()) {
            System.out.println(words.poll().w);
        }
    }
}