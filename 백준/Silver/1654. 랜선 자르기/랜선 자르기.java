import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);

		int[] len = new int[n];
		int maxNum = 0;
		for (int i = 0; i < n; i++) {
			len[i] = Integer.parseInt(br.readLine());
			maxNum = Math.max(maxNum, len[i]);
			
		}
		long minValue = 1, maxValue = maxNum;
		long mid = 0, cnt = 0;
		while (minValue <= maxValue) {
			cnt = 0;
			mid = (minValue + maxValue)/2;
			for(int l : len) {
				cnt += (l/mid);
			}
			if(cnt < k) {
				maxValue = mid-1;
			}
			else {
				minValue = mid+1;
			}
		}
		System.out.println(maxValue);
	}
}