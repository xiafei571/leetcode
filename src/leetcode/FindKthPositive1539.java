package leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindKthPositive1539 {
	public int findKthPositive(int[] arr, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : arr) {
			set.add(i);
		}

		int num = 1;
		while (k > 0) {
			if (!set.contains(num)) {
				k--;
			}

			if (k != 0) {
				num++;
			}

		}
		return num;
	}
}
