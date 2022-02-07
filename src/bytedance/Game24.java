package bytedance;

public class Game24 {
	public boolean judgePoint24(int[] cards) {
		double[] d = new double[] { cards[0], cards[1], cards[2], cards[3] };
		return helper(d);
	}

	private static boolean helper(double[] d) {
		if (d.length == 1) {
			return Math.abs(d[0] - 24) < 0.001;
		}

		for (int i = 0; i < d.length; i++) {
			for (int j = i + 1; j < d.length; j++) {

				double[] temp = new double[d.length - 1];
				int idx = 0;
				for (int k = 0; k < d.length; k++) {
					if (k != i && k != j) {
						temp[idx++] = d[k];
					}
				}

				for (double num : compute(d[i], d[j])) {
					temp[temp.length - 1] = num;
					if (helper(temp)) {
						return true;
					}
				}

			}
		}

		return false;

	}

	private static double[] compute(double a, double b) {
		return new double[] { a + b, a - b, b - a, a * b, a / b, b / a };
	}
}
