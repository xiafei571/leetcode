package algo.mock;

import java.util.HashSet;
import java.util.Set;

public class GetDifferentNumber {
	static int getDifferentNumber(int[] arr) {
		// O(NlogN) Time -> O(N) Time
		// O(1) SPACE -> O(N) SPACE
		// Arrays.sort(arr);
		Set<Integer> set = new HashSet<Integer>();
		for (int num : arr) {
			set.add(num);
		}

		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}

		return arr.length;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 2, 3 };
		System.out.println(getDifferentNumber(arr));
	}
}
