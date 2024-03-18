import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> max = new PriorityQueue<>();
		StringBuilder sb  = new StringBuilder();
		
		int mid = Integer.parseInt(br.readLine());
		min.add(mid);
		sb.append(mid).append("\n");
		
		for(int i = 0; i < N-1; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp > mid) {
				max.add(tmp);
			}else {
				min.add(tmp);
			}
			if(Math.abs(max.size() - min.size()) <= 1) {
				if(max.size() == min.size() || max.size() < min.size() ) {
					mid = min.peek();
				}
				else {
					mid = max.peek();
				}
			}else {
				while(true) {
					if(Math.abs(max.size() - min.size()) <= 1) {
						break;
					}
					if(max.size() > min.size()) {
						min.add(max.poll());
					}else {
						max.add(min.poll());
					}
				}
				if(max.size() == min.size() || max.size() < min.size() ) {
					mid = min.peek();
				}
				else {
					mid = max.peek();
				}
			}
			sb.append(mid).append("\n");
		}
		System.out.println(sb);
	}

}