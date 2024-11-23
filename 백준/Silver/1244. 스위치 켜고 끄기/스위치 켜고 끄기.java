import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] light = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			light[i] = Integer.parseInt(st.nextToken());
		}

		int O = Integer.parseInt(br.readLine());
		for (int i = 0; i < O; i++) {
			st = new StringTokenizer(br.readLine());
			int flag = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (flag == 1) {
				for (int j = 1; j <= N / num; j++) {
					light[j * num - 1] = light[j * num - 1] == 0 ? 1 : 0;
				}
			} else {
				num -= 1;
				int c = 1;
				light[num] = light[num] == 0 ? 1 : 0;
				while (true) {
					if (num - c >= 0 && num + c < N && light[num - c] == light[num + c]) {
						light[num - c] = light[num - c] == 0 ? 1 : 0;
						light[num + c] = light[num + c] == 0 ? 1 : 0;
						c++;
					}else {
						break;
					}
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			System.out.print(light[i] + " ");
			cnt++;
			if(cnt == 20) {
				System.out.println();
				cnt = 0;
			}
		}
	}
}