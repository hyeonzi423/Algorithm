import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            if (line.equals("END")) break;
            out.append(new StringBuilder(line).reverse()).append('\n');
        }

        System.out.print(out.toString());
    }
}