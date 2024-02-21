import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int L, C;
	static char[] list, secretCode;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
		list = new char[C];
		secretCode = new char[L];
		
		st = new StringTokenizer(br.readLine());
        for (int x = 0; x < C; x++) {
            list[x] = st.nextToken().charAt(0);
        }

        Arrays.sort(list);

        dfs(0,0);
	}

	private static void dfs(int start, int cnt) {
		if(cnt == L) {
			int a = 0, b = 0;
			for(char tmp : secretCode) {
				if(tmp == 'a' || tmp == 'e' || tmp == 'i' ||tmp == 'o' || tmp == 'u') {
					a++;
				}else {
					b++;
				}
			}
			if(a >= 1 && b >= 2) {
				System.out.println(secretCode);
			}
			return;
		}
		for(int i = start; i < C; i++) {
			secretCode[cnt] = list[i];
			dfs(i + 1, cnt + 1);
		}
	}

}