import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	static int num;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

		for (int i = 0; i < tc; i++) {
			num = Integer.parseInt(br.readLine());
			backtracking("1", 2);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void backtracking(String arg, int current) {
		if (current > num) {
			if (cal(arg) == 0) {
				sb.append(arg).append("\n");
			}
			return;
		}

		backtracking(arg + " " + current, current + 1);
		backtracking(arg + "+" + current, current + 1);
		backtracking(arg + "-" + current, current + 1);
	}

	public static int cal(String string) {
		String real = string.replace(" ", "");
		ArrayList<Integer> nums = new ArrayList<>();
		ArrayList<Character> operator = new ArrayList<>();

		String num = "";
		for (char c : real.toCharArray()) {
			if (c == '+' || c == '-') {
				nums.add(Integer.parseInt(num));
				operator.add(c);
				num = "";
			} else {
				num += c;
			}
		}
		nums.add(Integer.parseInt(num));

		int ret = nums.get(0);
		for (int i = 0; i < operator.size(); i++) {
			if (operator.get(i) == '+') {
				ret += nums.get(i + 1);
			} else {
				ret -= nums.get(i + 1);
			}
		}
		return ret;
	}
}