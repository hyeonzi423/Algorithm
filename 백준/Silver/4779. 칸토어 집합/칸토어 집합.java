import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            int len = (int) Math.pow(3, n);
            char[] arr = new char[len];
            for (int i = 0; i < len; i++) arr[i] = '-';

            cantor(arr, 0, len);

            System.out.println(new String(arr));
        }
    }

    public static void cantor(char[] arr, int start, int len){
        if(len < 3) return;

        int third = len / 3;
        for(int i = start + third; i < start + 2 * third; i++){
            arr[i] = ' ';
        }

        cantor(arr, start, third);
        cantor(arr, start + 2 * third, third);
    }
}