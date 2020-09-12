package leetcode;

public class SpairMatrix {

	public static void main(String[] args) {
		int[][] rs = spiralMatrixIII(5, 6, 1, 4);

		for (int i = 0; i < rs.length; i++) {
			for (int j = 0; j < rs[i].length; j++) {
				System.out.print(rs[i][j] + " ");
			}
			System.out.println();
		}
//		System.out.println(2<<1);
	}

	public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		// xxxx: 11 22, 33 44
		// step: 12 34, 56 78
		int n = 1;
		int step = 1;

		int[][] result = new int[R * C][2];
		int[] current_pos = { r0, c0 };
		result[0][0] = current_pos[0];
		result[0][1] = current_pos[1];

		while (n < R * C) {
			// right-> 2step-1
			for (int i = 0; i < step / 2 + 1; i++) {
				current_pos[1] = current_pos[1] + 1;
				if (current_pos[0] < R && current_pos[1] < C && current_pos[0]>=0 && current_pos[1]>=0) {
					result[n][0] = new Integer(current_pos[0]);
					result[n][1] = new Integer(current_pos[1]);
					n++;
				}
			}
			step++;
			// down->2step
			for (int j = 0; j < step / 2; j++) {
				current_pos[0] = current_pos[0] + 1;
				if (current_pos[0] < R && current_pos[1] < C && current_pos[0]>=0 && current_pos[1]>=0) {
					result[n][0] = new Integer(current_pos[0]);
					result[n][1] = new Integer(current_pos[1]);
					n++;
				}
			}
			step++;
			// left-> 2step-1
			for (int i = 0; i < step / 2 + 1; i++) {
				current_pos[1] = current_pos[1] - 1;
				if (current_pos[0] < R && current_pos[1] < C && current_pos[0]>=0 && current_pos[1]>=0) {
					result[n][0] = new Integer(current_pos[0]);
					result[n][1] = new Integer(current_pos[1]);
					n++;
				}
			}
			step++;
			// up->2n
			for (int j = 0; j < step / 2; j++) {
				current_pos[0] = current_pos[0] - 1;
				if (n < R * C && current_pos[0] < R && current_pos[1] < C && current_pos[0]>=0 && current_pos[1]>=0) {
					result[n][0] = new Integer(current_pos[0]);
					result[n][1] = new Integer(current_pos[1]);
					n++;
				}
			}
			step++;

		}
		return result;
	}

}
