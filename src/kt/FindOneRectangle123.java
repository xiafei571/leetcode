package kt;

public class FindOneRectangle123 {
	/**
	 * Q1:there is an image filled with 0s and 1s. There is at most one rectangle in
	 * this image filled with 0s, find the rectangle. Output could be the
	 * coordinates of top-left and bottom-right elements of the rectangle, or
	 * top-left element, width and height. 输出可以是矩形的左上角和右下角的坐标，或者左上角坐标+宽度和高度。
	 * 
	 * Q2:for the same image, it is filled with 0s and 1s. It may have multiple rectangles filled with 0s. 
	 * The rectangles are separated by 1s. Find all the rectangles.
	 * 
	 * Q3: the image has random shapes filled with 0s, separated by 1s. Find all the shapes. 
	 * Each shape is represented by coordinates of all the elements inside.
	 */
	public static void main(String[] args) {
		int[][] board = { 
				{ 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		findOneRectangle(board);
	}

	private static void findOneRectangle(int[][] board) {
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if (board[x][y] == 0) {
					int endX = x;
					int endY = y;
					while (endX < board.length && board[endX][y] == 0) {
						endX++;
					}

					while (endY < board[0].length && board[x][endY] == 0) {
						endY++;
					}

					if (endX > x+1 && endY > y+1) {
						if (isRectangle(board, x, y, endX, endY)) {
							endX--;
							endY--;
							System.out.println("find rectangle:" + x+" "+ y+" "+ endX+" "+ endY);
						}
					}
				}
			}
		}
	}

	private static boolean isRectangle(int[][] board, int x, int y, int endX, int endY) {
		for (int i = x; i < endX; i++) {
			for (int j = y; j < endY; j++) {
				if (board[i][j] == 1) {
					return false;
				}
				board[i][j] = -1;
			}
		}
		return true;
	}

}
