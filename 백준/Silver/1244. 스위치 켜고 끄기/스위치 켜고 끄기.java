import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] light = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			light[i] = Integer.parseInt(st.nextToken());
		}
		
		int student = Integer.parseInt(br.readLine());
		int gender, num;
		for(int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			if(gender == 1) {
				num =  Integer.parseInt(st.nextToken());
				for(int j = 1; j <= N; j++) {
					if(j%num == 0) {
						light[j] = (light[j] + 1)%2;
					}
				}
			}else {
				int check = 0;
				num =  Integer.parseInt(st.nextToken());
				light[num] = (light[num] + 1)%2;
				for(int j = 1; j < N/2; j++) {
					if(num - j > 0 && num + j <= N) {
						if(light[num - j] == light[num + j]) {
							light[num - j] = (light[num - j] + 1)%2;
							light[num + j] = (light[num + j] + 1)%2;
						}else {
							check = 1;
						}
					}
					if(check == 1) {
						break;
					}
				}
				
			}
		}
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			System.out.print(light[i] + " ");
			cnt += 1;
			if(cnt == 20) {
				System.out.println();
				cnt = 0;
			}
		}
	}
}