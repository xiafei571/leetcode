package am;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku36 {
	public boolean isValidSudoku(char[][] board) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char num = board[i][j];
				if (num != '.') {
					if (!set.add(num + "row" + i) || !set.add(num + "col" + j)
							|| !set.add(num + "box" + i / 3 + "_" + j / 3)) {
						return false;
					}
				}
			}
		}

		return true;
	}
}
