import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Character> write = new LinkedList<>();
        String tmp = br.readLine();
        for (int i = 0; i < tmp.length(); i++) {
            write.add(tmp.charAt(i));
        }

        ListIterator<Character> cursor = write.listIterator(tmp.length());
        int order = Integer.parseInt(br.readLine());

        for (int i = 0; i < order; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String o = st.nextToken();

            if (o.equals("L")) {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                }
            } else if (o.equals("D")) {
                if (cursor.hasNext()) {
                    cursor.next();
                }
            } else if (o.equals("B")) {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            } else {
                Character c = st.nextToken().charAt(0);
                cursor.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : write) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}