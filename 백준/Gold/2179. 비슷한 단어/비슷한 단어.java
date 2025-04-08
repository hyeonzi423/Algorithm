import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];

		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}

		int maxLen = -1;
		int idx1 = -1, idx2 = -1;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int len = commonPrefixLength(words[i], words[j]);

				if (len > maxLen || (len == maxLen && (i < idx1 || (i == idx1 && j < idx2)))) {
					maxLen = len;
					idx1 = i;
					idx2 = j;
				}
			}
		}

		System.out.println(words[idx1]);
		System.out.println(words[idx2]);
	}

	public static int commonPrefixLength(String a, String b) {
		int len = Math.min(a.length(), b.length());
		for (int i = 0; i < len; i++) {
			if (a.charAt(i) != b.charAt(i))
				return i;
		}
		return len;
	}
}