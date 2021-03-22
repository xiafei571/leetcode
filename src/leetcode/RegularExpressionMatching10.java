package leetcode;

public class RegularExpressionMatching10 {

	public static void main(String[] args) {
//		System.out.println(isMatch("aa", "a*"));
//		System.out.println(isMatch("ab", "*"));
//		System.out.println(isMatch("ab", ".*"));
//		System.out.println(isMatch("a", ".*..a*"));
//		System.out.println(isMatch("", "."));
		System.out.println(isMatch("", ""));
	}

	public static boolean isMatch(String s, String p) {
		if (s.equals(p))
			return true;

		String[] ss = s.split("");
		String[] ps = p.split("");
		int[][] matrix;
		if ("".equals(s)) {
			matrix = new int[1][ps.length + 1];
		} else {
			matrix = new int[ss.length + 1][ps.length + 1];
		}
		matrix[0][0] = 1;
		// first line
		for (int j = 1; j < matrix[0].length; j++) {
			if (ps[j - 1].equals("*")) {
				if (j >= 2) {
					matrix[0][j] = matrix[0][j - 2];
				} else {
					matrix[0][j] = 1;
				}

			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (ps[j - 1].equals(".") || ps[j - 1].equals(ss[i - 1])) {
					matrix[i][j] = matrix[i - 1][j - 1];
				} else if (ps[j - 1].equals("*")) {
					if (j < 2) {
						if (i == 1 || ss[i - 1].equals(ss[i - 2])) {
							matrix[i][j] = 1;
						}
					} else if (matrix[i][j - 2] == 1) {
						matrix[i][j] = 1;
					} else {
						if ((ps[j - 2].equals(".") || ps[j - 2].equals(ss[i - 1])) && matrix[i - 1][j] == 1) {
							matrix[i][j] = 1;
						}
					}
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

		return matrix[matrix.length - 1][matrix[0].length - 1] == 1;
	}
}
