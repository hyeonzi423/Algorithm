import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[5][5];       
    static boolean[][] marked = new boolean[5][5]; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        boolean done = false;

        for (int i = 0; i < 5 && !done; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5 && !done; j++) {
                int number = Integer.parseInt(st.nextToken());
                count++;
                mark(number);

                if (checkBingo() >= 3) {
                    System.out.println(count);
                    done = true;
                }
            }
        }
    }

    static void mark(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == number) {
                    marked[i][j] = true;
                    return;
                }
            }
        }
    }

    static int checkBingo() {
        int bingo = 0;

        for (int i = 0; i < 5; i++) {
            boolean row = true;
            for (int j = 0; j < 5; j++) {
                if (!marked[i][j]) {
                    row = false;
                    break;
                }
            }
            if (row) bingo++;
        }

        for (int j = 0; j < 5; j++) {
            boolean col = true;
            for (int i = 0; i < 5; i++) {
                if (!marked[i][j]) {
                    col = false;
                    break;
                }
            }
            if (col) bingo++;
        }

        boolean diag1 = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) {
                diag1 = false;
                break;
            }
        }
        if (diag1) bingo++;

        boolean diag2 = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][4 - i]) {
                diag2 = false;
                break;
            }
        }
        if (diag2) bingo++;

        return bingo;
    }
}