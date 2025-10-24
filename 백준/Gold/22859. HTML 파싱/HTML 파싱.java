import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String html = br.readLine();

        // 1. main parser
        int s = "<main>".length();
        int e = "</main>".length();
        html = html.substring(s, html.length() - e);

        // 2. div parser
        html = html.replaceAll("<div +title=\"([\\w ]*)\">", "title : $1\n");
        html = html.replaceAll("</div>", "");

        // 3. p parser
        html = html.replaceAll("<p>(.*?)</p>", "$1\n");

        // 4. p parser - remove all tag
        html = html.replaceAll("<([\\w /]*)>", "");

        // 5. p parser - trim
        html = html.replaceAll(" ?\n ?", "\n");
        
        // 6. p parser - two space -> one space
        html = html.replaceAll(" {2,}", " ");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(html);
        bw.flush();
        bw.close();
    }
}