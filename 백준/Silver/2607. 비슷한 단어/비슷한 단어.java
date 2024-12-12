import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String origin = br.readLine();

		HashMap<Character, Integer> hs = new HashMap<>();
		for (int i = 0; i < origin.length(); i++) {
			Character c = origin.charAt(i);
			hs.put(c, hs.getOrDefault(c, 0) + 1);
		}

		int ans = 0;
		for (int t = 0; t < N - 1; t++) {
			String str = br.readLine();
			
			if(Math.abs(origin.length() - str.length()) > 1) {
				continue;
			}
			
			HashMap<Character, Integer> hsTmp = new HashMap<>();
			for (int i = 0; i < str.length(); i++) {
				Character c = str.charAt(i);
				hsTmp.put(c, hsTmp.getOrDefault(c, 0) + 1);
			}
			
			if (isSimilar(hs, hsTmp)) {
                ans++;
            }
		}
		System.out.println(ans);
	}

	private static boolean isSimilar(HashMap<Character, Integer> hs, HashMap<Character, Integer> hsTmp) {
		int diff = 0;
		
		for(char c : hs.keySet()) {
			int cnt1 = hs.getOrDefault(c, 0);
			int cnt2 = hsTmp.getOrDefault(c, 0);
			diff += Math.abs(cnt1 - cnt2);
		}
		
		for(char c : hsTmp.keySet()) {
			if(!hs.containsKey(c)) {
				diff += hsTmp.get(c);
			}
		}
		
		return diff <= 2;
	}

}