import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().replace(" ", "");

        if(str.equals("12345678")){
            System.out.println("ascending");
        }else if(str.equals("87654321")){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }
    }
}

