package algo.expert;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

	public static void main(String[] args) {
		// System.out.println(minNumberOfCoinsForChange(10, new int[] {1, 3, 4}));
		System.out.println(minNumberOfCoinsForChange3(7, new int[] { 1, 5, 10 }));
		System.out.println(minNumberOfCoinsForChange3(9, new int[] { 3, 5 }));
		System.out.println(minNumberOfCoinsForChange3(10, new int[] { 1, 3, 4 }));
		System.out.println(minNumberOfCoinsForChange3(9, new int[] { 3, 4, 5 }));
	}

	public static int minNumberOfCoinsForChange3(int n, int[] denoms) {
		int[] nums = new int[n + 1];
		Arrays.fill(nums, -1);
		nums[0] = 0;
		for (int denom : denoms) {
			for (int i = 1; i < nums.length; i++) {
				if (denom <= i) {
					if (nums[i - denom] == -1) {

					} else if (nums[i] != -1) {
						nums[i] = Math.min(nums[i], 1 + nums[i - denom]);
					}else {
						nums[i] = 1 + nums[i - denom];
					}
				}
			}
		}
		return nums[n];
	}

	public static int minNumberOfCoinsForChange2(int n, int[] denoms) {
		// Write your code here.
		int[][] nums = new int[denoms.length][n + 1];
		for (int i = 0; i < denoms.length; i++) {
			int denom = denoms[i];
			for (int j = 1; j <= n; j++) {
				if (denom > j) {
					if (i == 0) {
						nums[i][j] = -1;
					} else {
						nums[i][j] = nums[i - 1][j];
					}
				} else {
					if (nums[i][j - denom] == -1) {
						if (i == 0) {
							nums[i][j] = -1;
						} else {
							nums[i][j] = nums[i - 1][j];
						}
					} else {
						if (i == 0) {
							nums[i][j] = 1 + nums[i][j - denom];
						} else if (nums[i - 1][j] == -1) {
							nums[i][j] = 1 + nums[i][j - denom];
						} else {
							nums[i][j] = Math.min(1 + nums[i][j - denom], nums[i - 1][j]);
						}
					}
				}

			}
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				System.out.print(nums[i][j] + ",");
			}
			System.out.println();
		}
		return nums[denoms.length - 1][n];
	}

	public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		// Write your code here.
		if (n <= 0) {
			return 0;
		}
		Arrays.sort(denoms);
		int m = denoms.length - 1;
		int num = -1;
		while (num == -1 && m >= 0) {
			num = numberOfCoins(n, denoms, m);
			m--;
		}
		return num;

	}

	private static int numberOfCoins(int n, int[] denoms, int m) {
		int num = 0;
		if (denoms.length == 0 || n < denoms[0]) {
			return -1;
		}

		if (n >= denoms[m]) {
			if (n % denoms[m] == 0) {
				return n / denoms[m];
			} else {
				if (m <= 0) {
					return -1;
				}
				num = n / denoms[m];
				int leftover = numberOfCoins(n % denoms[m], denoms, --m);
				if (leftover < 0) {
					return -1;
				} else {
					num += leftover;
				}
			}
		} else {
			if (m > 0) {
				num = numberOfCoins(n, denoms, --m);
			}
		}
		return num;
	}
}
