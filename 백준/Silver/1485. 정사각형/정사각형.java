import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int getSquare(int num) {
		return num * num;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i< n; i ++) {
			int[][] point = new int[4][2];
			for(int j = 0; j < 4; j++) {
				String[] tmp = br.readLine().split(" ");
				point[j][0] = Integer.parseInt(tmp[0]);
				point[j][1] = Integer.parseInt(tmp[1]);
			}
			
			Arrays.sort(point, (p1, p2) -> {
				if(p1[0] == p2[0]) {
					return p1[1] - p2[1];
				}
				else {
					return p1[0] - p2[0];
				}
			});
			int c1 = getSquare(point[2][1] - point[1][1]) + getSquare(point[2][0] - point[1][0]);
			int c2 = getSquare(point[3][1] - point[0][1]) + getSquare(point[3][0] - point[0][0]);
			int l1 = getSquare(point[1][1] - point[0][1]) + getSquare(point[1][0] - point[0][0]);
			int l2 = getSquare(point[2][1] - point[0][1]) + getSquare(point[2][0] - point[0][0]);
			
			if(c1 == c2 && l1 ==l2) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
	}
}