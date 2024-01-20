import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static boolean isPrime(int n) {
		for(int p = 2; p < (int)Math.sqrt(n) + 1; p++) {
			if (n % p == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = br.readLine().split(" ");
		int[] num = new int[2]; 
		for(int i = 0; i < 2; i++) {
			num[i] = Integer.parseInt(nums[i]);
		}
		
		int start = num[0];
		if (start == 1) start = 2;
		
		for(int i = start; i < num[1] + 1; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}
}