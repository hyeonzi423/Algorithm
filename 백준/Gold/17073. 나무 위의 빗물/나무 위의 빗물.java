import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int leafNode =0;
	static List<Integer>[] list;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}
        
		for(int i = 0; i< n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 2; i < n + 1; i++) {
			if(list[i].size() == 1) leafNode++;
		}
		System.out.println(String.format("%.10f", (double)w / leafNode));
	}
}