import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    static boolean[] check;
    static HashSet<String> set;
    
	public static int solution(String[] userid, String[] banid) {
        
        check = new boolean[userid.length];
        set = new HashSet<String>();
        
        for(int i = 0; i < banid.length; i++) 
        	banid[i] = banid[i].replace('*', '.');
        
        back(0,"",banid,userid);
        
		return set.size();
	}
	
	public static void back(int depth, String res, String[] banid, String[] userid) {
		if(depth == banid.length) {
			String[] arr = res.split(" ");
			Arrays.sort(arr);
			
			String str="";
			for(String s:arr) str+=s;
			set.add(str);
		
			return;
		}
		
		for(int i = 0; i < userid.length; i++) {
			if(check[i] || !userid[i].matches(banid[depth])) continue;			
			check[i] = true;
			back(depth + 1, userid[i] + " " + res, banid, userid);
			check[i] = false;
		}
	}
}