package ktng;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonContinuousSubarray {
	// 2. Longest Common Continuous Subarray

	private static List<String> longestCommonContinuousHistory(String[] user1, String[] user2) {

		int[][] dp = new int[user1.length + 1][user2.length + 1];
		List<String> res = new ArrayList<>();

		int curr_index = 0;
		int size = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (user1[i - 1].equals(user2[j - 1])) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (dp[i][j] > size) {
						curr_index = i;
						size = dp[i][j];
					}
				}
			}
		}

		System.out.println(curr_index + ":" + size);

		for (int i = curr_index - size; i < curr_index; i++) {
			res.add(user1[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		String user1[] = { "3234.html", "xys.html", "7hsaa.html" };
		String user2[] = { "3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html" };

		List<String> rs = longestCommonContinuousHistory(user1, user2);
		for (String str : rs) {
			System.out.print(str + " ");
		}
		System.out.println();

	}
}
