import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		String word = br.readLine();
		int s = string.length();
		int w = word.length();

		Stack<Character> stack = new Stack<>();
		int idx = 0;

		while (idx < s) {
			stack.add(string.charAt(idx));
			idx++;

			if (stack.size() >= w) {
				boolean isMatch = true;
				for (int i = 0; i < w; i++) {
					if (stack.get(stack.size() - w + i) != word.charAt(i)) {
						isMatch = false;
						break;
					}
				}

				if (isMatch) {
					for (int i = 0; i < w; i++) {
						stack.pop();
					}
				}
			}
		}

		if (stack.size() == 0) {
			System.out.println("FRULA");
		} else {
			StringBuilder result = new StringBuilder();
			for (Character c : stack) {
				result.append(c);
			}
			System.out.println(result);
		}
	}
}
