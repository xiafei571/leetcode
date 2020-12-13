package algo.expert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		Arrays.sort(array);
		List<Integer[]> result = new ArrayList<Integer[]>();
		for (int i = 0; i < array.length - 2; i++) {
			int left = i + 1;
			int right = array.length - 1;
			while (left < right) {
				int sum = array[i] + array[left] + array[right];
				if (sum == targetSum) {
					result.add(new Integer[] { array[i], array[left], array[right] });
					left++;
					right--;
				} else if (sum < targetSum) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}
}
