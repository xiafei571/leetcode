package leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		if (x < Integer.MIN_VALUE) {
			return 0;
		}

		int result = 0;
		while (x != 0) {

			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && x % 10 > 7))
				return 0;
			if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && x % 10 < -8))
				return 0;

			result = (10 * result) + (x % 10);
			x = x / 10;
		}

		return result;
	}
}
