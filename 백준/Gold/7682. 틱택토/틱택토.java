import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder sb = new StringBuilder();

		while (!(line = br.readLine()).equals("end")) {
			if (isValid(line)) {
				sb.append("valid").append("\n");
			} else {
				sb.append("invalid").append("\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean isValid(String board) {
		int xCount = 0, oCount = 0;

		for (char c : board.toCharArray()) {
			if (c == 'X')
				xCount++;
			else if (c == 'O')
				oCount++;
		}

		if (xCount < oCount || xCount > oCount + 1)
			return false;

		boolean xWin = checkWin(board, 'X');
		boolean oWin = checkWin(board, 'O');

		if (xWin && oWin)
			return false;

		if (xWin && xCount != oCount + 1)
			return false;

		if (oWin && xCount != oCount)
			return false;

		if (!xWin && !oWin && xCount + oCount != 9)
			return false;

		return true;
	}

	private static boolean checkWin(String board, char player) {
		int[][] winConditions = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
				{ 0, 4, 8 }, { 2, 4, 6 } };

		for (int[] condition : winConditions) {
			if (board.charAt(condition[0]) == player && board.charAt(condition[1]) == player
					&& board.charAt(condition[2]) == player) {
				return true;
			}
		}
		return false;
	}
}