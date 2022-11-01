package am;

public class ProductExceptSelf238Redo {
	public int[] productExceptSelf(int[] nums) {
		// [1,1,2,6] [24,12,4,1]

		if (nums.length <= 1) {
			return nums;
		}

		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				left[0] = 1;
				right[nums.length - 1] = 1;
			} else {
				left[i] = nums[i - 1] * left[i - 1];
				right[nums.length - 1 - i] = nums[nums.length - i] * right[nums.length - i];
			}
		}

		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = left[i] * right[i];
		}

		return res;
	}
}
