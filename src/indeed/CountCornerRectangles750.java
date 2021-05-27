package indeed;

import java.util.ArrayList;
import java.util.List;

public class CountCornerRectangles750 {
	public int countCornerRectangles750(int[][] grid) {
		int res = 0;
		int row = grid.length;
		int col = grid[0].length;
		if (row == 1)
			return res;
		for (int r1 = 0; r1 < row - 1; r1++) {
			for (int r2 = r1 + 1; r2 < row; r2++) {
				int count = 0;
				for (int j = 0; j < col; j++) {
					if (grid[r1][j] == 1 && grid[r2][j] == 1)
						count++;
				}
				//C(n,2) = (n*n-1)/2
				res += count * (count - 1) / 2;
			}
		}
		return res;
	}
/*
 * Give a matrix of 1's and 0's. For example, matrix = [
["1","1","1","1","1"],
["1","1","0","0","1"],
["1","1","0","0","1"],
["1","1","1","1","1"]
]

Round 1: find the rectangle that is made of 0s, either return the start and end index OR height and length of the rectangle. There is only 1 rectangle in each matrix. I solved it by looping to find the first and last zero.

Round 2: same problem but now the matrix may contains many rectangles. 
Return the start and end indexes of each rec in an array.

matrix = [
["0","1","1","1","1"],
["1","1","0","0","1"],
["0","1","0","0","1"],
["0","1","1","1","1"],
["1","0","1","1","1"]
] => 4 rectangles in here . 0 by itself is also a rectangle, and vertical rectangle also counts.
 */
	
	public static void countCornerRectangles(char[][] grid) {
		List<Integer[]> list = new ArrayList<Integer[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0') {
					list.add(new Integer[] { i, j });
				}
			}
		}
		System.out.println("start" + list.get(0));
		System.out.println("end" + list.get(list.size() - 1));
	}
	
	public static void countCornerRectangles2(char[][] grid) {
		//同LeetCode200
		//遍历全部，遇到0就res++，然后DFS遍历把0->2
	}
}
