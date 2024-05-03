import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char[] aeiou = { 'a', 'e', 'i', 'o', 'u' };

		while (true) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			
			if (input.equals("end"))
				break;
			
			else {
				boolean acceptable = true;
				boolean have = false;
				
				int cntAEIOU = 0;
				int cntOther = 0;
				
				for (int i = 0; i < input.length(); i++) {
					char now = input.charAt(i);
					boolean isAEIOU = false;
					
					for (int j = 0; j < aeiou.length; j++) {
						if (now == aeiou[j]) {
							isAEIOU = true;
							have = true;
							cntAEIOU++;
							cntOther = 0;
							break;
						}
					}

					if (!isAEIOU) {
						cntOther++;
						cntAEIOU = 0;
					}
					
					if (i == input.length() - 1) {
						if (!have) {
							System.out.println("<" + input + "> is not acceptable.");
							acceptable = false;
							break;
						}
					}
					if (i >= 1) {
						if (now == input.charAt(i - 1) && now != 'e' && now != 'o') {
							System.out.println("<" + input + "> is not acceptable.");
							acceptable = false;
							break;
						}

						else if (cntAEIOU >= 3 || cntOther >= 3) {
							System.out.println("<" + input + "> is not acceptable.");
							acceptable = false;
							break;
						}
					}
				}
				if (acceptable)
					System.out.println("<" + input + "> is acceptable.");
			}
		}
	}
}