import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long count = 0;

        for(int i=0; i<N-2; i++) {
            int left = i + 1;
            int right = N - 1;

            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if(sum == 0) {
                    if(arr[left] == arr[right]) {
                        int len = right - left + 1;
                        count += (long) len * (len - 1) / 2; // 조합
                        break;
                    } else {
                        int l = 1;
                        int r = 1;
                        while(left + 1 < right && arr[left] == arr[left + 1]) {
                            l++;
                            left++;
                        }
                        while(right - 1 > left && arr[right] == arr[right - 1]) {
                            r++;
                            right--;
                        }
                        count += (long) l * r;
                        left++;
                        right--;
                    }
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(count);
    }
}