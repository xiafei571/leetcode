package algo.expert;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
	public static List<Integer> spiralTraverse(int[][] array) {
		List<Integer> result = new ArrayList<Integer>();
		int startRow = 0;
		int startCol = 0;
		int endRow = array.length - 1;
		int endCol = array[0].length - 1;
		while (startRow <= endRow && startCol <= endCol) {
			for (int col = startCol; col <= endCol; col++) {
				result.add(array[startRow][col]);
			}

			for (int row = startRow + 1; row <= endRow; row++) {
				result.add(array[row][endCol]);
			}

			for (int col = endCol - 1; col >= startCol; col--) {
				if (startRow == endRow)
					break;
				result.add(array[endRow][col]);
			}

			for (int raw = endRow - 1; raw > startRow; raw--) {
				if (startCol == endCol)
					break;
				result.add(array[raw][startCol]);
			}

			startRow++;
			startCol++;
			endRow--;
			endCol--;
		}

		return result;
	}
}
