package am;

public class FindMin153 {
	public int findMin(int[] nums) {
		// [3,4,5,6,7,1,2]
		// [6,7,1,2,3,4,5]
		// [1,2,3,4,5,6,7]

		int len = nums.length;

		if (len == 1) {
			return nums[0];
		}

		int left = 0;
		int right = len - 1;

		while (left + 1 < right) {
			int mid = (left + right) / 2;

			if (nums[mid] > nums[right]) {
				left = mid;
			} else if (nums[mid] < nums[right]) {
				right = mid;
			}
		}

		return Math.min(nums[left], nums[right]);

	}
}
