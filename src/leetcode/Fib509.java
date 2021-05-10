package leetcode;

public class Fib509 {
	public int fib(int n) {
		if (n < 1) {
			return 0;
		} else {
			int[] F = new int[n + 1];
			F[0] = 0;
			F[1] = 1;
			for (int i = 2; i <= n; i++) {
				F[i] = F[i - 1] + F[i - 2];
			}
			return F[n];
		}
	}
}
