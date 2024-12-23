import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    
    static int N;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();

        char[] ver1 = new char[N]; // 첫번째 스위치 안 누름
        char[] ver2 = new char[N]; // 첫번째 스위치 누름

        int cnt1 = 0;
        int cnt2 = 1;

        for(int i = 0; i < N; i++){
            ver1[i] = str1.charAt(i);
            ver2[i] = str1.charAt(i);
        }

        change(ver2, 0);

        for(int i = 1; i < N; i++){
            if(ver1[i-1] != str2.charAt(i-1)){
                change(ver1, i);
                cnt1++;
            }if(ver2[i-1] != str2.charAt(i-1)){
                change(ver2, i);
                cnt2++;
            }
        }

        boolean f1 = isSame(ver1, str2);
        boolean f2 = isSame(ver2, str2);

        if (f1 && f2) {
            System.out.println(Math.min(cnt1, cnt2));
        } else if (f1) {
            System.out.println(cnt1);
        } else if (f2) {
            System.out.println(cnt2);
        } else {
            System.out.println(-1);
        }
    }

    public static void change(char[] arr, int idx){
        for(int i = -1; i < 2; i++){
            if(idx + i >= 0 && idx + i < N){
                arr[idx + i] = arr[idx + i] == '1'? '0' : '1';
            }
        }
    }
    
    public static boolean isSame(char[] arr, String target) {
        for (int i = 0; i < N; i++) {
            if (arr[i] != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}